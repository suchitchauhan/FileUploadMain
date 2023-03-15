package com.example.FileUploadMain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class FileUploadMainApplication {

	Logger logger= LoggerFactory.getLogger(FileUploadMainApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FileUploadMainApplication.class, args);
	}

//@Scheduled(fixedRate = 2000L)
//@Scheduled(fixedDelay = 5000L)
	//2 means that is 2 second , 2 house etc.
//@Scheduled(fixedDelayString ="PT2S") //second
//@Scheduled(fixedDelayString ="PT2H") //hours
//@Scheduled(fixedDelayString ="PT2M") //minutes
//@Scheduled(fixedDelayString ="PT2D") //minutes
//@Scheduled(fixedDelayString ="PT10S") //minutes

	//For Fix Some long Times like Days , Months etc.
			//in cron 6 paramters
//		 *		   *              *                *                  *            *
//	   Second    minute         Hour              Day[Month]        Month       Day[Week]
		 	//https://crontab [web site for lerarn]

	 @Scheduled(cron = "*/1 * * * * *")
	//End
	public void job(){
			logger.info("Job Current Time :: "+ new Date());
			//Thread.sleep(1000)
		}


	@Scheduled(fixedRate = 2000L)
	public void job2(){
		logger.info("Job2 Current Time :: "+ new Date());
		//Thread.sleep(1000)
	}

}
