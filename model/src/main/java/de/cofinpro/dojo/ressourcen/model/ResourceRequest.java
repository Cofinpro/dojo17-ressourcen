package de.cofinpro.dojo.ressourcen.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

public class ResourceRequest implements DataObject {

    @Id
    private ObjectId id;

    private String title;
    private String customerName;
    private String projectName;
    private CustomerRole role;
    private String location;
    private String projectDescription;
    private String taskDescription;
    private String[] requiredSkills;
    private String[] additionalSkills;
    private Boolean englishRequired;
    private Date pitchDeadline;
    private Date decisionDate;
    private Double propability;
    private Date runTimeStart;
    private Date runTimeEnd;
    private Double dayRate;
    private String[] extraConditions;
    private Integer workload;

    @Override
    public String getId() {
        if (id != null) {
            return String.valueOf(id);
        }
        return null;
    }

    public void setId(String id) {
        if (id != null) {
            this.id = new ObjectId(id);
        }
        id = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CustomerRole getRole() {
        return role;
    }

    public void setRole(CustomerRole role) {
        this.role = role;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String[] getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String[] requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String[] getAdditionalSkills() {
        return additionalSkills;
    }

    public void setAdditionalSkills(String[] additionalSkills) {
        this.additionalSkills = additionalSkills;
    }

    public Boolean getEnglishRequired() {
        return englishRequired;
    }

    public void setEnglishRequired(Boolean englishRequired) {
        this.englishRequired = englishRequired;
    }

    public Date getPitchDeadline() {
        return pitchDeadline;
    }

    public void setPitchDeadline(Date pitchDeadline) {
        this.pitchDeadline = pitchDeadline;
    }

    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    public Double getPropability() {
        return propability;
    }

    public void setPropability(Double propability) {
        this.propability = propability;
    }

    public Date getRunTimeStart() {
        return runTimeStart;
    }

    public void setRunTimeStart(Date runTimeStart) {
        this.runTimeStart = runTimeStart;
    }

    public Date getRunTimeEnd() {
        return runTimeEnd;
    }

    public void setRunTimeEnd(Date runTimeEnd) {
        this.runTimeEnd = runTimeEnd;
    }

    public Double getDayRate() {
        return dayRate;
    }

    public void setDayRate(Double dayRate) {
        this.dayRate = dayRate;
    }

    public String[] getExtraConditions() {
        return extraConditions;
    }

    public void setExtraConditions(String[] extraConditions) {
        this.extraConditions = extraConditions;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceRequest that = (ResourceRequest) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
