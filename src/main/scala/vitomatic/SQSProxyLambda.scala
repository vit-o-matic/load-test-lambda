package vitomatic

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.{Region, Regions}
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.sqs.AmazonSQSClient
import com.amazonaws.services.sqs.model.{CreateQueueRequest, GetQueueUrlRequest}
import com.fasterxml.jackson.databind.ObjectMapper
import com.typesafe.config.ConfigFactory
import vitomatic.model.SingleHitResult
import scala.util.Try

/**
  * @author Hussachai Puripunpinyo
  */
class LoadHitResultQueue {

  val objectMapper = new ObjectMapper()

  val config = ConfigFactory.load()

  lazy val awsCredentials = new BasicAWSCredentials(
    config.getString("aws.accessKeyId"),
    config.getString("aws.secretAccessKey"))

  val queueName = config.getString("aws.sqs.queueName")

  val sqs = new AmazonSQSClient(awsCredentials)
  sqs.setRegion(Region.getRegion(Regions.US_WEST_2)) //same region as EC2
  Try(sqs.createQueue(new CreateQueueRequest(queueName)))

  def enqueue(data: SingleHitResult, ctx: Context): String = {
    val queueUrl = sqs.getQueueUrl(new GetQueueUrlRequest(queueName)).getQueueUrl
    val json = objectMapper.writeValueAsString(data)
    val messageId = sqs.sendMessage(queueUrl, json).getMessageId
    messageId
  }

  def echo(data: String): String = {
    s"Hello ${data}"
  }

}

