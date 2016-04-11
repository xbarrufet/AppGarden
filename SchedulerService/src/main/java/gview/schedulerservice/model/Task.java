package gview.schedulerservice.model;

public class Task {

	private String taskId;
	private String type;
	private String status;
	private String parentTaskId;
	private String description;
	
	
	public final String TYPE_SERVICE="SERVICE";
	public final String TYPE_INCIDENT="INCIDENT";
	
	public final String STATUS_PENDING="PENDING";
	public final String STATUS_COMPLETE="COMPLETE";
	
	public Task() {
		
	}

	public Task(Builder builder) {
		this.type=builder.type;
		this.status=builder.status;
		this.parentTaskId=builder.parentTaskId;
		this.description=builder.description;
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static class Builder {
		
		private String type;
		private String status;
		private String parentTaskId;
		private String description;
		
		public Task build() {
			return new Task(this);
		}
		
		
		public Builder type(String type) {
			this.type=type;
			return this;
		}
		
		public Builder status(String status) {
			this.status=status;
			return this;
		}
		public Builder parentTaskId(String parentTaskId) {
			this.parentTaskId=parentTaskId;
			return this;
		}
		public Builder description(String description) {
			this.description=description;
			return this;
		}
		
	}
	
	
}


