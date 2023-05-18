package com.iit.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.iit.entity.Product;
import com.iit.listner.MyJobListner;
import com.iit.processor.ProductProcessor;

@Configuration

@EnableBatchProcessing
public class BatchConfig 
{
	// reader class object
	@Bean
	public FlatFileItemReader<Product> reader()
	{
		FlatFileItemReader<Product> reader=new FlatFileItemReader<>();
		
		reader.setResource(new ClassPathResource("Products.csv"));
		reader.setLineMapper(new DefaultLineMapper<Product>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(DELIMITER_COMMA);
				setNames("prodId","prodName","prodCost");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {{
				setTargetType(Product.class);
			}});
		}});
		return reader;
	}
	//item processor class object
	@Bean
	public ItemProcessor<Product, Product> processor()
	{
		return new ProductProcessor();
		/*
		 * return item ->{ double cost = item.getProdCost(); item.setProdDisc(cost *
		 * 12/100.0); item.setProdGst(cost * 18/100.0); return item; };
		 */
		
	}
	//add datasource jdbc conn pool
	@Autowired
	private DataSource dataSource;
	
	// writer class object
	@Bean
	public JdbcBatchItemWriter<Product> writer()
	{
		JdbcBatchItemWriter<Product> writer=new JdbcBatchItemWriter<>();
		writer.setDataSource(dataSource);
		writer.setSql("INSERT INTO products(prod_id,prod_cost,prod_disc,prod_gst,prod_name) VALUES(:prodId,:prodCost,:prodDisc,:prodGst,:prodName)");
		//it converts the object into sql queries
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());
		return writer;
		
	}
	
	//listner class object
	@Bean
	public JobExecutionListener listner()
	{
		return new MyJobListner();
		
		/*
		 * return new JobExecutionListener(){
		 * 
		 * @Override public void beforeJob(JobExecution je) {
		 * 
		 * System.out.println("Started Date and Time: "+new Date());
		 * System.out.println("Status At Starting.."+je.getStatus()); }
		 * 
		 * @Override public void afterJob(JobExecution je) {
		 * 
		 * System.out.println("Ended Date and Time: "+new Date());
		 * System.out.println("Status At Ending.."+je.getStatus());
		 * 
		 * }
		 */
	}
	
	//autowire step builder factory
	
	@Autowired
	private StepBuilderFactory sf;
	//create step object
	@Bean
	public Step stepA()
	{
		return sf.get("stepA")
				.<Product,Product>chunk(3)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
				
    }
	
	//7. job builder factory
		@Autowired
		private JobBuilderFactory jf;
		
		//8. job 
		@Bean
		public Job jobA() {
			return jf.get("jobA")
					.listener(listner())
					.incrementer(new RunIdIncrementer())
					.start(stepA())
					.build();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
