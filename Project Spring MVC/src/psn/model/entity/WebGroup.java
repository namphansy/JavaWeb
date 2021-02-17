package psn.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Web_Group")
public class WebGroup {
	@Id
	@Column(name = "Group_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupId;
	@Column(name = "Group_Name")
	private String groupName;
	@Column(name = "Group_Status")
	private boolean groupStatus; 

	public WebGroup() {
		// TODO Auto-generated constructor stub
	}

	public WebGroup(int groupId, String groupName, boolean groupStatus) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupStatus = groupStatus;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public boolean isGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(boolean groupStatus) {
		this.groupStatus = groupStatus;
	}
	
	
}
