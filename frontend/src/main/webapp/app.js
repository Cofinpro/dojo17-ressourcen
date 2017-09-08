var app = new Vue({
  el: '#app',
  data: {
    request: {
        title: "Titel",
        customer: "Kundenname",
        project: "Projektname",
        role: "Rolle",
        location: "Ortsangabe",
        projectDescription: "",
        taskDescription: "",
        requiredSkills: [],
        additionalSkills: [],
        englishRequired: false,
        pitchDeadline: "",
        decisionDate: "",
        probability: "",
        runTimeStart: "",
        runTimeEnd: "",
        dayRate: 500,
        extraConditions: "",
        workload: 20,
    },
    message: 'Hello Vue!'
  }
})