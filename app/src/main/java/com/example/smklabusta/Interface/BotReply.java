package com.example.smklabusta.Interface;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;

public interface BotReply {

  void callback (DetectIntentResponse returnResponse);

}
