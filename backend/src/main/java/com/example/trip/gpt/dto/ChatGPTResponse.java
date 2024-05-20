package com.example.trip.gpt.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChatGPTResponse {
    private List<Choice> choices;


    public ChatGPTResponse() {
		super();
	}


	public ChatGPTResponse(List<Choice> choices) {
		super();
		this.choices = choices;
	}


	public List<Choice> getChoices() {
		return choices;
	}


	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}


	@Data
    public static class Choice {
        private int index;
        private Message message;
        
        
		public Choice() {
			super();
		}


		public Choice(int index, Message message) {
			super();
			this.index = index;
			this.message = message;
		}


		public int getIndex() {
			return index;
		}


		public void setIndex(int index) {
			this.index = index;
		}


		public Message getMessage() {
			return message;
		}


		public void setMessage(Message message) {
			this.message = message;
		}
		
		

    }
}
