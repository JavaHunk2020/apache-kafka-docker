package com.consumer.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	/*
	 * @KafkaListener( topicPartitions = @TopicPartition(topic = "topicName",
	 * partitionOffsets = {
	 * 
	 * @PartitionOffset(partition = "0", initialOffset = "0"),
	 * 
	 * @PartitionOffset(partition = "3", initialOffset = "0")}), containerFactory =
	 * "partitionsKafkaListenerContainerFactory") public void listenToPartition(
	 * 
	 * @Payload String message,
	 * 
	 * @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
	 * System.out.println("Received Message: " + message+ "from partition: " +
	 * partition); }
	 */

	@Value("${general.topic.name}")
	private String[] topicName;

	@Value("${general.topic.group.id}")
	private String consumerGroupName;
	
	//@Autowired
	//private EmployeeRepository employeeRepository;
	
	@PostConstruct
	public void init() {
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		
		
		System.out.println("-------"+consumerGroupName+"----------");
		System.out.println("-------"+topicName+"----------");
		System.out.println("###############################################");
		
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");
		System.out.println("###############################################");

		
	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = "loan-process", partitionOffsets = {
			@PartitionOffset(partition = "0", initialOffset = "0", relativeToCurrent = "true") }), containerFactory = "concurrentKafkaListenerContainer", groupId = "loanProcess")
	public void consumer1(String message) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!###############################################");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!###############################################");
		System.out.println("Reading message from topic partition 0= " + message);
	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = "loan-process", partitionOffsets = {
			@PartitionOffset(partition = "1", initialOffset = "0"),
			@PartitionOffset(partition = "2", initialOffset = "0"),
			@PartitionOffset(partition = "3", initialOffset = "0") }), containerFactory = "concurrentKafkaListenerContainer", groupId = "customerProcess")
	public void consumer2(String message) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!###############################################");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!###############################################");
		
		System.out.println("Reading message from topic 1,2,3= " + message);
	}

	/*
	 * @KafkaListener(topics = { "customer-loan-topic100"}, containerFactory =
	 * "econcurrentKafkaListenerContainer", groupId = "technohun100") public void
	 * Emplooyeeconsumer(BusinessDataDTO businessDataDTO) {
	 * 
	 * 
	 * System.out.println(
	 * "!!!!!!!!!!!!!!!!!!!!!!!!!!!!###############################################"
	 * );
	 * 
	 * System.out.println(
	 * "!!!!!!!!!!!!!!!!!!!!!!!!!!!!###############################################"
	 * );
	 * 
	 * System.out.println(
	 * "!!!!!!!!!!!!!!!!!!!!!!!!!!!!###############################################"
	 * );
	 * 
	 * 
	 * System.out.println("businessDataDTO.getData() instanceof EmployeeDTO = "+(
	 * businessDataDTO.getData() instanceof EmployeeDTO)); if
	 * (businessDataDTO.getData() instanceof EmployeeDTO) {
	 * System.out.println("Reading employeeDTO message from topic = " +
	 * businessDataDTO.getData()); //Employee
	 * employee=convertToEntity((EmployeeDTO)businessDataDTO.getData());
	 * //employeeRepository.save(employee); } else {
	 * System.out.println("Reading else message from topic = " +
	 * businessDataDTO.getData()); }
	 * 
	 * }
	 */
	
	/*
	 * private Employee convertToEntity(EmployeeDTO employeeDTO) { return
	 * Stream.of(employeeDTO) .map((EmployeeDTO ed)->{ Employee employee=new
	 * Employee(); BeanUtils.copyProperties(ed, employee); return employee;
	 * }).findFirst().get(); }
	 */
}
