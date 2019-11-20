package com.example.NexmoSmsIntegration;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.MessageStatus;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMessage {
    public static void main(String[] args) throws Exception {

        final Logger LOGGER = LoggerFactory.getLogger(SendMessage.class);

        String NEXMO_API_KEY = "b01ac53a";
        String NEXMO_API_SECRET = "bkvjh3JXwji3N5Mh";
        String TO_NUMBER = "919133259525";
        String NEXMO_BRAND_NAME ="NEXMO";

        NexmoClient client = new NexmoClient.Builder()
                .apiKey(NEXMO_API_KEY)
                .apiSecret(NEXMO_API_SECRET)
                .build();
        String messageText = "Welcome To FullPlate!";
        TextMessage message = new TextMessage(NEXMO_BRAND_NAME,TO_NUMBER,messageText);

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
        for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
            LOGGER.info(String.valueOf(responseMessage));
        }

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            LOGGER.info("Message sent successfully."); }
//            System.out.println("Message sent successfully."); }
        else {
            LOGGER.info("Message failed with error: " + response.getMessages().get(0).getErrorText());}
//            System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText()); }
    }
}



