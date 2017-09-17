import ListInput from './ListInput/ListInput.vue'
import MapInput from './MapInput/MapInput.vue'
import PureCss from 'purecss'
import Axios from 'axios'

function flattenList(valueList) {
    var result = [];
    for (var i = 0; i < valueList.length; i++) {
        var v = valueList[i];
        result[i] = v["value"];
    }
    return result;
}

function flattenMap(valueMap) {
    var result = {};
    for (var i = 0; i < valueMap.length; i++) {
        var v = valueMap[i];
        result[v["key"]] = v["value"];
    }
    return result;
}

export default {
  name: 'resourcenanfrage',
  data () {
    return {
        request: this.initRequest()
    }
  },
  components: {
    ListInput, MapInput, PureCss, Axios
  },
  methods: {
    initRequest: function () {
        var newRequest = {
            title: "",
            status: "DRAFT",
            customerName: "",
            projectName: "",
            roleName: "",
            location: "",
            projectDescription: "",
            taskDescription: "",
            requiredSkills: [{value: ""}],
            additionalSkills: [{value: ""}],
            englishRequired: false,
            englishLevelRequirements: "NONE",
            pitchDeadline: "",
            decisionDate: "",
            probability: "",
            runTimeStart: "",
            runTimeEnd: "",
            dayRate: 500,
            extraConditions: "",
            workload: 20,
            candidates: [{value: ""}],
            externalConsultants: false,
            entryLevel: false,
            internalBackup: "",
            competition: [
                { key: "", value: "" }
            ],
            followUpBusiness: "",
            positioningCustomer: 3,
            positioningCustomerReason: "",
            crossSellingPotential: 3,
            crossSellingPotentialReason: "",
            profileSyncContact: "",
            externalContact: "",
            customerType: "",
            externalRole: "",
            externalLocation: "",
            externalProjectDescription: "",
            externalTaskDescription: "",
            externalRequiredSkills: [{value: ""}],
            externalAdditionalSkills: [{value: ""}],
            externalExtensionOption: false,
            externalProjectDuration: 8,
            externalExtraConditions: "",
        };
        var viewRequest = newRequest;
        var localRequestJson = localStorage != null ? localStorage.getItem("request") : null;
        if (localRequestJson != null) {
            var localRequest = JSON.parse(localRequestJson || '[]');
            viewRequest = localRequest;
        }
        return viewRequest;
    },
    save: function(submitMode) {
        if ("publish" == submitMode) {
            alert("Publish!");
            var postRequest = JSON.parse(JSON.stringify(this.request));
    
            postRequest["requiredSkills"] = flattenList(postRequest["requiredSkills"]);
            postRequest["additionalSkills"] = flattenList(postRequest["additionalSkills"]);
            postRequest["candidates"] = flattenList(postRequest["candidates"]);
            postRequest["externalRequiredSkills"] = flattenList(postRequest["externalRequiredSkills"]);
            postRequest["externalAdditionalSkills"] = flattenList(postRequest["externalAdditionalSkills"]);
    
            postRequest["competition"] = flattenMap(postRequest["competition"]);
    
            postRequest["status"] = "OPEN";
    
            var restHost = location.protocol + '//' + location.hostname;
    
            Axios.post(restHost.concat(':8080/resources-service/resources/requests/create'), postRequest)
                .then(response => {
                    alert("Erfolgreich abgeschickt!");
                })
                .catch(e => {
                  alert(e);
                });
        } else {
            if (localStorage) {
                localStorage.setItem("request", JSON.stringify(this.request));
                alert("Erfolgreich gesichert!");
            } else {
                alert("Speichern nicht möglich, bitte direkt veröffentlichen!");
            }
        }
    },
    onSubmit: function(event) {
        this.save("publish");
    },
    clear: function(event) {
        event.preventDefault();
        this.request = newRequest;
    }
  }
}