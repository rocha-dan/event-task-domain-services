package br.com.rocha.dan.task.event.document;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import br.com.rocha.dan.task.event.enums.EventStatus;

public class EventDocument implements Serializable {
	private static final long serialVersionUID = -6669389865249708171L;

	@Id
	private String eventId = new ObjectId().toHexString();
	private EventStatus status;
	private MessageEvent message;
	private String requeueTo;
	private int attemptedCount;

	public EventDocument() {
	}

	private EventDocument(Builder builder) {
		this.eventId = builder.eventId;
		this.status = builder.status;
		this.message = builder.message;
		this.requeueTo = builder.requeueTo;
		this.attemptedCount = builder.attemptedCount;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public EventStatus getStatus() {
		return status;
	}

	public void setStatus(EventStatus status) {
		this.status = status;
	}

	public MessageEvent getMessage() {
		return message;
	}

	public void setMessage(MessageEvent message) {
		this.message = message;
	}

	public String getRequeueTo() {
		return requeueTo;
	}

	public void setRequeueTo(String requeueTo) {
		this.requeueTo = requeueTo;
	}

	public int getAttemptedCount() {
		return attemptedCount;
	}

	public void setAttemptedCount(int attemptedCount) {
		this.attemptedCount = attemptedCount;
	}

	@Override
	public String toString() {
		return "WebHookDocument [webHookId=" + eventId + ", status=" + status + ", message=" + message + ", attemptedCount="
				+ attemptedCount + "]";
	}

	public static class Builder {
		private String eventId;
		private EventStatus status;
		private MessageEvent message;
		private String requeueTo;
		private int attemptedCount;

		public Builder eventId(String webHookId) {
			this.eventId = webHookId;
			return this;
		}

		public Builder status(EventStatus status) {
			this.status = status;
			return this;
		}

		public Builder message(MessageEvent message) {
			this.message = message;
			return this;
		}

		public Builder requeueTo(String requeueTo) {
			this.requeueTo = requeueTo;
			return this;
		}

		public Builder attemptedCount(int attemptedCount) {
			this.attemptedCount = attemptedCount;
			return this;
		}

		public EventDocument build() {
			return new EventDocument(this);
		}
	}
}