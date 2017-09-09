package de.cofinpro.dojo.ressourcen.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class ResourceRequest implements DataObject {

    @Id
    private ObjectId id;

    private String title;
    private String customerName;
    private String projectName;
    private String roleName;
    private String location;
    private String projectDescription;
    private String taskDescription;
    private String[] requiredSkills;
    private String[] additionalSkills;
    private Boolean englishRequired;
    private EnglishLevel englishLevelRequirements;
    private Date pitchDeadline;
    private Date decisionDate;
    private Double probability;
    private Date runTimeStart;
    private Date runTimeEnd;
    private Double dayRate;
    private String[] extraConditions;
    private Integer workload;
    private String[] candidates;
    private Boolean externalConsultants;
    private Boolean entryLevel;
    private String internalBackup;
    private Map<String, String> competition;
    private String followUpBusiness;
    private Integer positioningCustomer;
    private String positioningCustomerReason;
    private Integer crossSellingPotential;
    private String crossSellingPotentialReason;
    private String profileSyncContact;
    private String externalContact;
    
    private String customerType;
    private String externalRole;
    private String externalLocation;
    private String externalProjectDescription;
    private String externalTaskDescription;
    private String[] externalRequiredSkills;
    private String[] externalAdditionalSkills;
    private Boolean externalExtensionOption;
    private Integer externalProjectDuration;
    private String externalExtraConditions;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public EnglishLevel getEnglishLevelRequirements() {
        return englishLevelRequirements;
    }

    public void setEnglishLevelRequirements(EnglishLevel englishLevelRequirements) {
        this.englishLevelRequirements = englishLevelRequirements;
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

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
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

    public String[] getCandidates() {
        return candidates;
    }

    public void setCandidates(String[] candidates) {
        this.candidates = candidates;
    }

    public Boolean getExternalConsultants() {
        return externalConsultants;
    }

    public void setExternalConsultants(Boolean externalConsultants) {
        this.externalConsultants = externalConsultants;
    }

    public Boolean getEntryLevel() {
        return entryLevel;
    }

    public void setEntryLevel(Boolean entryLevel) {
        this.entryLevel = entryLevel;
    }

    public String getInternalBackup() {
        return internalBackup;
    }

    public void setInternalBackup(String internalBackup) {
        this.internalBackup = internalBackup;
    }

    public Map<String, String> getCompetition() {
        return competition;
    }

    public void setCompetition(Map<String, String> competition) {
        this.competition = competition;
    }

    public String getFollowUpBusiness() {
        return followUpBusiness;
    }

    public void setFollowUpBusiness(String followUpBusiness) {
        this.followUpBusiness = followUpBusiness;
    }

    public Integer getPositioningCustomer() {
        return positioningCustomer;
    }

    public void setPositioningCustomer(Integer positioningCustomer) {
        this.positioningCustomer = positioningCustomer;
    }

    public String getPositioningCustomerReason() {
        return positioningCustomerReason;
    }

    public void setPositioningCustomerReason(String positioningCustomerReason) {
        this.positioningCustomerReason = positioningCustomerReason;
    }

    public Integer getCrossSellingPotential() {
        return crossSellingPotential;
    }

    public void setCrossSellingPotential(Integer crossSellingPotential) {
        this.crossSellingPotential = crossSellingPotential;
    }

    public String getCrossSellingPotentialReason() {
        return crossSellingPotentialReason;
    }

    public void setCrossSellingPotentialReason(String crossSellingPotentialReason) {
        this.crossSellingPotentialReason = crossSellingPotentialReason;
    }

    public String getProfileSyncContact() {
        return profileSyncContact;
    }

    public void setProfileSyncContact(String profileSyncContact) {
        this.profileSyncContact = profileSyncContact;
    }

    public String getExternalContact() {
        return externalContact;
    }

    public void setExternalContact(String externalContact) {
        this.externalContact = externalContact;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getExternalRole() {
        return externalRole;
    }

    public void setExternalRole(String externalRole) {
        this.externalRole = externalRole;
    }

    public String getExternalLocation() {
        return externalLocation;
    }

    public void setExternalLocation(String externalLocation) {
        this.externalLocation = externalLocation;
    }

    public String getExternalProjectDescription() {
        return externalProjectDescription;
    }

    public void setExternalProjectDescription(String externalProjectDescription) {
        this.externalProjectDescription = externalProjectDescription;
    }

    public String getExternalTaskDescription() {
        return externalTaskDescription;
    }

    public void setExternalTaskDescription(String externalTaskDescription) {
        this.externalTaskDescription = externalTaskDescription;
    }

    public String[] getExternalRequiredSkills() {
        return externalRequiredSkills;
    }

    public void setExternalRequiredSkills(String[] externalRequiredSkills) {
        this.externalRequiredSkills = externalRequiredSkills;
    }

    public String[] getExternalAdditionalSkills() {
        return externalAdditionalSkills;
    }

    public void setExternalAdditionalSkills(String[] externalAdditionalSkills) {
        this.externalAdditionalSkills = externalAdditionalSkills;
    }

    public Boolean getExternalExtensionOption() {
        return externalExtensionOption;
    }

    public void setExternalExtensionOption(Boolean externalExtensionOption) {
        this.externalExtensionOption = externalExtensionOption;
    }

    public Integer getExternalProjectDuration() {
        return externalProjectDuration;
    }

    public void setExternalProjectDuration(Integer externalProjectDuration) {
        this.externalProjectDuration = externalProjectDuration;
    }

    public String getExternalExtraConditions() {
        return externalExtraConditions;
    }

    public void setExternalExtraConditions(String externalExtraConditions) {
        this.externalExtraConditions = externalExtraConditions;
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
        if (!Objects.equals(roleName, that.roleName)) return false;
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
        if (probability != null ? !probability.equals(that.probability) : that.probability != null) return false;
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
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (projectDescription != null ? projectDescription.hashCode() : 0);
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(requiredSkills);
        result = 31 * result + Arrays.hashCode(additionalSkills);
        result = 31 * result + (englishRequired != null ? englishRequired.hashCode() : 0);
        result = 31 * result + (pitchDeadline != null ? pitchDeadline.hashCode() : 0);
        result = 31 * result + (decisionDate != null ? decisionDate.hashCode() : 0);
        result = 31 * result + (probability != null ? probability.hashCode() : 0);
        result = 31 * result + (runTimeStart != null ? runTimeStart.hashCode() : 0);
        result = 31 * result + (runTimeEnd != null ? runTimeEnd.hashCode() : 0);
        result = 31 * result + (dayRate != null ? dayRate.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(extraConditions);
        result = 31 * result + (workload != null ? workload.hashCode() : 0);
        return result;
    }
}
