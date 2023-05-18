package com.mit.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.mit.model.Business;
import com.mit.repo.BusinessRepo;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	// A.create a reader object
	@Bean
	public ItemReader<Business> reader() {
		FlatFileItemReader<Business> reader = new FlatFileItemReader<>();
		reader.setResource(new FileSystemResource("src/main/resources/Employee.csv"));
		reader.setName("csvReader");
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;

	}

	private LineMapper<Business> lineMapper() {
		DefaultLineMapper<Business> linemapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer LineTokenizer = new DelimitedLineTokenizer();
		LineTokenizer.setDelimiter(",");
		LineTokenizer.setStrict(false);
		LineTokenizer.setNames("id", "name","city","salary");
		BeanWrapperFieldSetMapper<Business> FieldSetMapper = new BeanWrapperFieldSetMapper<>();
		FieldSetMapper.setTargetType(Business.class);

		linemapper.setLineTokenizer(LineTokenizer);
		linemapper.setFieldSetMapper(FieldSetMapper);

		return linemapper;
	}
	//B.create a processor object
	@Bean
	public ItemProcessor<Business, Business> processor()
	{
		return new BusinessProcessor();
	}
	//.autowire custom repo
	@Autowired
	private BusinessRepo businessRepository;
	
	//C.create a writer object
	@Bean
	public RepositoryItemWriter<Business> writer()
	{
		RepositoryItemWriter<Business> writer=new RepositoryItemWriter<>();
		writer.setRepository(businessRepository);
		writer.setMethodName("save");
		return writer;
	}
	//create listner object
	@Bean
	public JobExecutionListener listener()
	{
		return new MyListner();
	}
	//autowire StepBuilderFactory object
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	//create step object
	@Bean
	public Step step1()
	{
		return stepBuilderFactory.get("step1")
		                  .<Business,Business>chunk(10)
		                  .reader( reader())
		                  .processor(processor())
		                  .writer(writer())
		                  .build();
		                  
	}
	//autowire jobBuilderFactory
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	//create a object of job
	@Bean
	public Job job1()
	{
		return jobBuilderFactory.get("job1")
				                .listener(listener())
				                .flow(step1())
				                .end()
				                .build();
				              
				                
	}
	
	
}
