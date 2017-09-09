Vue.component('removable-input', {
  props: ['item','label'],
  template: '<div><label>{{ label }}</label><input type="text" v-model="item.value" v-on:input="updateValue($event.target.value)" placeholder=""><input type="button" v-on:click="removeInput" value="-"></input></div>',
  methods: {
    updateValue: function(value) {
      this.$emit('input', value);
    },
    removeInput: function () {
      this.$emit('removed');
    }
  }
});

Vue.component('removable-dual-input', {
  props: ['item','keyLabel','valueLabel'],
  template: '<div><label>{{ keyLabel }}</label><input type="text" v-model="item.key" v-on:input="updateValue($event.target.key)" placeholder=""><label>{{ valueLabel }}</label><input type="text" v-model="item.value" v-on:input="updateValue($event.target.value)" placeholder=""><input type="button" v-on:click="removeInput" value="-"></input></div>',
  methods: {
    updateValue: function(value) {
      this.$emit('input', value);
    },
    removeInput: function () {
      this.$emit('removed');
    }
  }
});

Vue.component('multi-inputs', {
  template: '<div class="multi-input"></input><removable-input v-bind:label="label" v-for="(item, index) in value" :item="item" :key="index" v-on:input="propagateChange" v-on:removed="removeListItem(index)"></removable-input><input type="button" v-on:click="addInput" value="+"></div>',
  props: ['value','label'],
  methods: {
    addInput: function () {
      this.$set(this.value, this.value.length, { value: "" });
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
  template: '<div class="map-input"></input><removable-dual-input v-bind:keyLabel="keyLabel" v-bind:valueLabel="valueLabel" v-for="(item, index) in value" :item="item" :key="index" v-on:input="propagateChange" v-on:removed="removeListItem(index)"></removable-dual-input><input type="button" v-on:click="addInput" value="+"></div>',
  props: ['value','keyLabel','valueLabel'],
  methods: {
    addInput: function () {
      this.$set(this.value, this.value.length, { key: "", value: ""});
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

var app = new Vue({
  el: '#app',
  data: {
    request: {
        title: "",
        customer: "",
        project: "",
        role: "",
        location: "",
        projectDescription: "",
        taskDescription: "",
        requiredSkills: [{value: ""}],
        additionalSkills: [{value: ""}],
        englishRequired: false,
        englishLevelRequirements: "",
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
    },
    message: 'Hello Vue!'
  }
});