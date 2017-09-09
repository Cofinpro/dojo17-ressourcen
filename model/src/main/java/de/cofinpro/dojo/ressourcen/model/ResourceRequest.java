package de.cofinpro.dojo.ressourcen.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import java.util.*;

public class ResourceRequest implements DataObject {

    @Id
    private ObjectId id;
    
    private RequestStatus status = RequestStatus.DRAFT;

    private String title;
    private String customerName;
    private String projectName;
    private String roleName;
    private String location;
    private String projectDescription;
    private String taskDescription;
    private List<String> requiredSkills;
    private List<String> additionalSkills;
    private Boolean englishRequired;
    private EnglishLevel englishLevelRequirements;
    private Date pitchDeadline;
    private Date decisionDate;
    private Double probability;
    private Date runTimeStart;
    private Date runTimeEnd;
    private Double dayRate;
    private String extraConditions;
    private Integer workload;
    private List<String> candidates;
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
    private List<String> externalRequiredSkills;
    private List<String> externalAdditionalSkills;
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

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
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

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public List<String> getAdditionalSkills() {
        return additionalSkills;
    }

    public void setAdditionalSkills(List<String> additionalSkills) {
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

    public String getExtraConditions() {
        return extraConditions;
    }

    public void setExtraConditions(String extraConditions) {
        this.extraConditions = extraConditions;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public List<String> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<String> candidates) {
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

    public List<String> getExternalRequiredSkills() {
        return externalRequiredSkills;
    }

    public void setExternalRequiredSkills(List<String> externalRequiredSkills) {
        this.externalRequiredSkills = externalRequiredSkills;
    }

    public List<String> getExternalAdditionalSkills() {
        return externalAdditionalSkills;
    }

    public void setExternalAdditionalSkills(List<String> externalAdditionalSkills) {
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

        ResourceRequest request = (ResourceRequest) o;

        if (id != null ? !id.equals(request.id) : request.id != null) return false;
        if (status != request.status) return false;
        if (title != null ? !title.equals(request.title) : request.title != null) return false;
        if (customerName != null ? !customerName.equals(request.customerName) : request.customerName != null)
            return false;
        if (projectName != null ? !projectName.equals(request.projectName) : request.projectName != null) return false;
        if (roleName != null ? !roleName.equals(request.roleName) : request.roleName != null) return false;
        if (location != null ? !location.equals(request.location) : request.location != null) return false;
        if (projectDescription != null ? !projectDescription.equals(request.projectDescription) : request.projectDescription != null)
            return false;
        if (taskDescription != null ? !taskDescription.equals(request.taskDescription) : request.taskDescription != null)
            return false;
        if (requiredSkills != null ? !requiredSkills.equals(request.requiredSkills) : request.requiredSkills != null)
            return false;
        if (additionalSkills != null ? !additionalSkills.equals(request.additionalSkills) : request.additionalSkills != null)
            return false;
        if (englishRequired != null ? !englishRequired.equals(request.englishRequired) : request.englishRequired != null)
            return false;
        if (englishLevelRequirements != request.englishLevelRequirements) return false;
        if (pitchDeadline != null ? !pitchDeadline.equals(request.pitchDeadline) : request.pitchDeadline != null)
            return false;
        if (decisionDate != null ? !decisionDate.equals(request.decisionDate) : request.decisionDate != null)
            return false;
        if (probability != null ? !probability.equals(request.probability) : request.probability != null) return false;
        if (runTimeStart != null ? !runTimeStart.equals(request.runTimeStart) : request.runTimeStart != null)
            return false;
        if (runTimeEnd != null ? !runTimeEnd.equals(request.runTimeEnd) : request.runTimeEnd != null) return false;
        if (dayRate != null ? !dayRate.equals(request.dayRate) : request.dayRate != null) return false;
        if (extraConditions != null ? !extraConditions.equals(request.extraConditions) : request.extraConditions != null)
            return false;
        if (workload != null ? !workload.equals(request.workload) : request.workload != null) return false;
        if (candidates != null ? !candidates.equals(request.candidates) : request.candidates != null) return false;
        if (externalConsultants != null ? !externalConsultants.equals(request.externalConsultants) : request.externalConsultants != null)
            return false;
        if (entryLevel != null ? !entryLevel.equals(request.entryLevel) : request.entryLevel != null) return false;
        if (internalBackup != null ? !internalBackup.equals(request.internalBackup) : request.internalBackup != null)
            return false;
        if (competition != null ? !competition.equals(request.competition) : request.competition != null) return false;
        if (followUpBusiness != null ? !followUpBusiness.equals(request.followUpBusiness) : request.followUpBusiness != null)
            return false;
        if (positioningCustomer != null ? !positioningCustomer.equals(request.positioningCustomer) : request.positioningCustomer != null)
            return false;
        if (positioningCustomerReason != null ? !positioningCustomerReason.equals(request.positioningCustomerReason) : request.positioningCustomerReason != null)
            return false;
        if (crossSellingPotential != null ? !crossSellingPotential.equals(request.crossSellingPotential) : request.crossSellingPotential != null)
            return false;
        if (crossSellingPotentialReason != null ? !crossSellingPotentialReason.equals(request.crossSellingPotentialReason) : request.crossSellingPotentialReason != null)
            return false;
        if (profileSyncContact != null ? !profileSyncContact.equals(request.profileSyncContact) : request.profileSyncContact != null)
            return false;
        if (externalContact != null ? !externalContact.equals(request.externalContact) : request.externalContact != null)
            return false;
        if (customerType != null ? !customerType.equals(request.customerType) : request.customerType != null)
            return false;
        if (externalRole != null ? !externalRole.equals(request.externalRole) : request.externalRole != null)
            return false;
        if (externalLocation != null ? !externalLocation.equals(request.externalLocation) : request.externalLocation != null)
            return false;
        if (externalProjectDescription != null ? !externalProjectDescription.equals(request.externalProjectDescription) : request.externalProjectDescription != null)
            return false;
        if (externalTaskDescription != null ? !externalTaskDescription.equals(request.externalTaskDescription) : request.externalTaskDescription != null)
            return false;
        if (externalRequiredSkills != null ? !externalRequiredSkills.equals(request.externalRequiredSkills) : request.externalRequiredSkills != null)
            return false;
        if (externalAdditionalSkills != null ? !externalAdditionalSkills.equals(request.externalAdditionalSkills) : request.externalAdditionalSkills != null)
            return false;
        if (externalExtensionOption != null ? !externalExtensionOption.equals(request.externalExtensionOption) : request.externalExtensionOption != null)
            return false;
        if (externalProjectDuration != null ? !externalProjectDuration.equals(request.externalProjectDuration) : request.externalProjectDuration != null)
            return false;
        return externalExtraConditions != null ? externalExtraConditions.equals(request.externalExtraConditions) : request.externalExtraConditions == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (projectDescription != null ? projectDescription.hashCode() : 0);
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        result = 31 * result + (requiredSkills != null ? requiredSkills.hashCode() : 0);
        result = 31 * result + (additionalSkills != null ? additionalSkills.hashCode() : 0);
        result = 31 * result + (englishRequired != null ? englishRequired.hashCode() : 0);
        result = 31 * result + (englishLevelRequirements != null ? englishLevelRequirements.hashCode() : 0);
        result = 31 * result + (pitchDeadline != null ? pitchDeadline.hashCode() : 0);
        result = 31 * result + (decisionDate != null ? decisionDate.hashCode() : 0);
        result = 31 * result + (probability != null ? probability.hashCode() : 0);
        result = 31 * result + (runTimeStart != null ? runTimeStart.hashCode() : 0);
        result = 31 * result + (runTimeEnd != null ? runTimeEnd.hashCode() : 0);
        result = 31 * result + (dayRate != null ? dayRate.hashCode() : 0);
        result = 31 * result + (extraConditions != null ? extraConditions.hashCode() : 0);
        result = 31 * result + (workload != null ? workload.hashCode() : 0);
        result = 31 * result + (candidates != null ? candidates.hashCode() : 0);
        result = 31 * result + (externalConsultants != null ? externalConsultants.hashCode() : 0);
        result = 31 * result + (entryLevel != null ? entryLevel.hashCode() : 0);
        result = 31 * result + (internalBackup != null ? internalBackup.hashCode() : 0);
        result = 31 * result + (competition != null ? competition.hashCode() : 0);
        result = 31 * result + (followUpBusiness != null ? followUpBusiness.hashCode() : 0);
        result = 31 * result + (positioningCustomer != null ? positioningCustomer.hashCode() : 0);
        result = 31 * result + (positioningCustomerReason != null ? positioningCustomerReason.hashCode() : 0);
        result = 31 * result + (crossSellingPotential != null ? crossSellingPotential.hashCode() : 0);
        result = 31 * result + (crossSellingPotentialReason != null ? crossSellingPotentialReason.hashCode() : 0);
        result = 31 * result + (profileSyncContact != null ? profileSyncContact.hashCode() : 0);
        result = 31 * result + (externalContact != null ? externalContact.hashCode() : 0);
        result = 31 * result + (customerType != null ? customerType.hashCode() : 0);
        result = 31 * result + (externalRole != null ? externalRole.hashCode() : 0);
        result = 31 * result + (externalLocation != null ? externalLocation.hashCode() : 0);
        result = 31 * result + (externalProjectDescription != null ? externalProjectDescription.hashCode() : 0);
        result = 31 * result + (externalTaskDescription != null ? externalTaskDescription.hashCode() : 0);
        result = 31 * result + (externalRequiredSkills != null ? externalRequiredSkills.hashCode() : 0);
        result = 31 * result + (externalAdditionalSkills != null ? externalAdditionalSkills.hashCode() : 0);
        result = 31 * result + (externalExtensionOption != null ? externalExtensionOption.hashCode() : 0);
        result = 31 * result + (externalProjectDuration != null ? externalProjectDuration.hashCode() : 0);
        result = 31 * result + (externalExtraConditions != null ? externalExtraConditions.hashCode() : 0);
        return result;
    }
}
