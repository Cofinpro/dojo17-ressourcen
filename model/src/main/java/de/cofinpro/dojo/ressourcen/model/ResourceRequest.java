package de.cofinpro.dojo.ressourcen.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import java.util.Arrays;
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (role != that.role) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (projectDescription != null ? !projectDescription.equals(that.projectDescription) : that.projectDescription != null)
            return false;
        if (taskDescription != null ? !taskDescription.equals(that.taskDescription) : that.taskDescription != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(requiredSkills, that.requiredSkills)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(additionalSkills, that.additionalSkills)) return false;
        if (englishRequired != null ? !englishRequired.equals(that.englishRequired) : that.englishRequired != null)
            return false;
        if (pitchDeadline != null ? !pitchDeadline.equals(that.pitchDeadline) : that.pitchDeadline != null)
            return false;
        if (decisionDate != null ? !decisionDate.equals(that.decisionDate) : that.decisionDate != null) return false;
        if (propability != null ? !propability.equals(that.propability) : that.propability != null) return false;
        if (runTimeStart != null ? !runTimeStart.equals(that.runTimeStart) : that.runTimeStart != null) return false;
        if (runTimeEnd != null ? !runTimeEnd.equals(that.runTimeEnd) : that.runTimeEnd != null) return false;
        if (dayRate != null ? !dayRate.equals(that.dayRate) : that.dayRate != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(extraConditions, that.extraConditions)) return false;
        return workload != null ? workload.equals(that.workload) : that.workload == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (projectDescription != null ? projectDescription.hashCode() : 0);
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(requiredSkills);
        result = 31 * result + Arrays.hashCode(additionalSkills);
        result = 31 * result + (englishRequired != null ? englishRequired.hashCode() : 0);
        result = 31 * result + (pitchDeadline != null ? pitchDeadline.hashCode() : 0);
        result = 31 * result + (decisionDate != null ? decisionDate.hashCode() : 0);
        result = 31 * result + (propability != null ? propability.hashCode() : 0);
        result = 31 * result + (runTimeStart != null ? runTimeStart.hashCode() : 0);
        result = 31 * result + (runTimeEnd != null ? runTimeEnd.hashCode() : 0);
        result = 31 * result + (dayRate != null ? dayRate.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(extraConditions);
        result = 31 * result + (workload != null ? workload.hashCode() : 0);
        return result;
    }
}
