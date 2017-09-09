package de.cofinpro.dojo.ressourcen.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;
import java.util.Map;

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

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
