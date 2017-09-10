Vue.component('removable-input', {
    props: ['item', 'label'],
    template: '<div><label>{{ label }}</label><input type="text" v-model="item.value" v-on:input="updateValue($event.target.value)" placeholder=""><input type="button" v-on:click="removeInput" value="-"></input></div>',
    methods: {
        updateValue: function (value) {
            this.$emit('input', value);
        },
        removeInput: function () {
            this.$emit('removed');
        }
    }
});

Vue.component('removable-dual-input', {
    props: ['item', 'keyLabel', 'valueLabel'],
    template: '<div><label>{{ keyLabel }}</label><input type="text" v-model="item.key" v-on:input="updateValue($event.target.key)" placeholder=""><label>{{ valueLabel }}</label><input type="text" v-model="item.value" v-on:input="updateValue($event.target.value)" placeholder=""><input type="button" v-on:click="removeInput" value="-"></input></div>',
    methods: {
        updateValue: function (value) {
            this.$emit('input', value);
        },
        removeInput: function () {
            this.$emit('removed');
        }
    }
});

Vue.component('multi-inputs', {
    template: '<div class="multi-input"><removable-input v-bind:label="label" v-for="(item, index) in value" :item="item" :key="index" v-on:input="propagateChange" v-on:removed="removeListItem(index)"></removable-input><input type="button" v-on:click="addInput" value="+"></div>',
    props: ['value', 'label'],
    methods: {
        addInput: function () {
            this.$set(this.value, this.value.length, {value: ""});
            this.$emit('input', this.value);
        },
        propagateChange: function () {
            this.$emit('input', this.value);
        },
        removeListItem: function (index) {
            this.$delete(this.value, index);
            this.$emit('input', this.value);
        }
    }
});

Vue.component('map-inputs', {
    template: '<div class="map-input"><removable-dual-input v-bind:keyLabel="keyLabel" v-bind:valueLabel="valueLabel" v-for="(item, index) in value" :item="item" :key="index" v-on:input="propagateChange" v-on:removed="removeListItem(index)"></removable-dual-input><input type="button" v-on:click="addInput" value="+"></div>',
    props: ['value', 'keyLabel', 'valueLabel'],
    methods: {
        addInput: function () {
            this.$set(this.value, this.value.length, {key: "", value: ""});
            this.$emit('input', this.value);
        },
        propagateChange: function () {
            this.$emit('input', this.value);
        },
        removeListItem: function (index) {
            this.$delete(this.value, index);
            this.$emit('input', this.value);
        }
    }
});

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
var localRequestJson = localStorage.getItem("request");
if (localRequestJson != null) {
    var localRequest = JSON.parse(localRequestJson || '[]');
    viewRequest = localRequest;
}

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

var app = new Vue({
  el: '#app',
  data: {
    request: viewRequest,    message: 'Hello Vue!'
  },
  methods: {
    save : function (event) {
        event.preventDefault();
        if (localStorage) {
            localStorage.setItem("request", JSON.stringify(this.request));
            alert("Erfolgreich gesichert!");
        } else {
            alert("Speichern nicht möglich, bitte direkt veröffentlichen!");
        }
    },
    publish: function(event) {

        var postRequest = JSON.parse(JSON.stringify(this.request));

        postRequest["requiredSkills"] = flattenList(postRequest["requiredSkills"]);
        postRequest["additionalSkills"] = flattenList(postRequest["additionalSkills"]);
        postRequest["candidates"] = flattenList(postRequest["candidates"]);
        postRequest["externalRequiredSkills"] = flattenList(postRequest["externalRequiredSkills"]);
        postRequest["externalAdditionalSkills"] = flattenList(postRequest["externalAdditionalSkills"]);

        postRequest["competition"] = flattenMap(postRequest["competition"]);

        postRequest["status"] = "OPEN";

        var restHost = location.protocol + '//' + location.hostname;

        axios.post(restHost.concat(':8080/resources-service/resources/requests/create'), postRequest)
            .then(response => {
                alert("Erfolgreich abgeschickt!");
            })
            .catch(e => {
              alert(e);
            });
    },
    clear: function(event) {
        event.preventDefault();
        this.request = newRequest;
    }
  }
});

/*
$(function () {
//do your own request an handle the results
    $.post({
        url: 'http://127.0.0.1:8080/resources-service/resources/requests/create',
        dataType: 'json',
        contentType: 'application/json',
        data: $("#app").serialize(),
        success: function (data) {
            console.log('data: ' + data);
        }
    });
});
*/