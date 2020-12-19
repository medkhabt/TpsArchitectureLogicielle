package com.architecture_logiciel.tp_spring_batch;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.architecture_logiciel.tp_spring_batch.entities.Transaction;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
 
	@Autowired 
	private JobBuilderFactory jobBuilderFactory; 
	
	@Autowired
	private StepBuilderFactory stepBuilderFactoy;
	
	@Autowired
	private ItemReader<Transaction> transactionItemReader; 
	
	@Autowired
	private ItemWriter<Transaction> transactionItemWriter; 
	
	@Autowired
	private ItemProcessor<Transaction, Transaction> transactionItemProcessor; 
	
	@Bean
	public Job transactionJob() {
		Step step1 = stepBuilderFactoy.get("step1")
				.<Transaction, Transaction>chunk(100)
				.reader(transactionItemReader)
				.processor(transactionItemProcessor)
				.writer(transactionItemWriter)
				.build(); 
		
		return jobBuilderFactory.get("bank-data-loader")
				.start(step1).build(); 
				
	}
	
	
	@Bean
	public FlatFileItemReader<Transaction> fileItemReader(@Value("${inputFile}")Resource inputFile){
		FlatFileItemReader<Transaction> fileItemReader = new FlatFileItemReader<>(); 
		fileItemReader.setName("ffir1");
		fileItemReader.setLinesToSkip(1);
		fileItemReader.setResource(inputFile);
		fileItemReader.setLineMapper(lineMapper());
		
		return fileItemReader; 
	}


	private LineMapper<Transaction> lineMapper() {
		DefaultLineMapper<Transaction> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer() ; 
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("idTransaction", "idCompte", "montant", "dateTransactionString");
		lineMapper.setLineTokenizer(lineTokenizer);
		BeanWrapperFieldSetMapper<Transaction> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Transaction.class);
		lineMapper.setFieldSetMapper(fieldSetMapper); 
		
		return lineMapper; 
	}
	
	
	@Bean
	public ItemProcessor<Transaction, Transaction> itemProcessor(){ 
		return new ItemProcessor<Transaction, Transaction>() {

			@Override
			public Transaction process(Transaction item) throws Exception {
				
				return null;
			}
			
		};
	}
	
}
