<template>
    <div id="ressourcenanfrage">
        <div class="logo">
            <img src="./assets/logo.png" class="pure-img" style="max-width:300px;">
        </div>
        <h1>Ressourcenanfrage</h1>
        <p>
            Im Falle einer Ressourcenanfrage ist dieses Formular mit dem Button "Veröffentlichen" abzusenden. Sollte der
            Zugriff auf den Server nicht möglich sein, so kann die Anfrage mittels "Speichern" zwischengespeichert
            werden und später abgeschickt werden. <strong>Unvollständig ausgefüllte Formulare werden nicht
            berücksichtigt.</strong>
        </p>
        <form id="app" class="pure-form pure-form-aligned" v-on:submit.prevent="onSubmit">
            <fieldset>
                <legend>Basisdaten</legend>

                <div class="pure-control-group">
                    <label for="requestTitle">Anfragetitel</label>
                    <input id="requestTitle" v-model="request.title" placeholder="Titel der Anfrage" required>
                </div>
                <div class="pure-control-group">
                    <label for="customer">Kunde</label>
                    <input id="customer" v-model="request.customerName" placeholder="Name des Kunden" required>
                </div>
                <div class="pure-control-group">
                    <label for="project">Projekt</label>
                    <input id="project" v-model="request.projectName" placeholder="Name des Projekts" required>
                </div>
                <div class="pure-control-group">
                    <label for="role">Rolle</label>
                    <input id="role" v-model="request.roleName" placeholder="Rolle innerhalb des Projekts" required>
                </div>

                <div class="pure-control-group">
                    <label for="location">Einsatzort</label>
                    <input id="location" v-model="request.location" placeholder="Einsatzort" required>
                </div>

                <div class="pure-control-group">
                    <label for="projectDescription">Kurze Beschreibung des Projekts </label>
                    <textarea id="projectDescription" v-model="request.projectDescription" placeholder="Beschreibung"
                              required></textarea>
                    <span class="pure-form-message-inline">(Welche Zielstellung verfolgt das Projekt bzw. der Einsatz?)</span>
                </div>

                <div class="pure-control-group">
                    <label for="taskDescription">Aufgabenbeschreibung </label>
                    <textarea id="taskDescription" v-model="request.taskDescription" placeholder="Beschreibung"
                              required></textarea>
                    <span class="pure-form-message-inline">(Welche Schnittstellen liegen vor? Einordnung im Projekt)</span>
                </div>

                <div class="pure-control-group">
                    <fieldset>
                        <legend for="requiredSkills">Notwendige Skills</legend>
                        <div id="requiredSkills">
                            <list-input v-model="request.requiredSkills" label="Fähigkeit"></list-input>
                        </div>
                        <span class="pure-form-message-inline">(idealerweise in absteigender Wichtigkeit)</span>
                    </fieldset>
                </div>

                <div class="pure-control-group">
                    <fieldset>
                        <legend for="additionalSkills">Wünschenswerte Skills (idealerweise in absteigender
                            Wichtigkeit)
                        </legend>
                        <div id="additionalSkills">
                            <list-input v-model="request.additionalSkills" label="Fähigkeit"></list-input>
                        </div>
                        <span class="pure-form-message-inline">(idealerweise in absteigender Wichtigkeit)</span>
                    </fieldset>
                </div>

                <div class="pure-control-group">
                    <label for="englishRequired" class="pure-checkbox">Englischkenntnisse zwingend</label>
                    <input type="checkbox" id="englishRequired" v-model="request.englishRequired">
                    <label for="englishLevelRequirements" class="pure-checkbox">wenn ja, erforderliches Level: </label>
                    <select id="englishLevelRequirements" v-model="request.englishLevelRequirements">
                        <option value="NONE"></option>
                        <option value="A1">A1</option>
                        <option value="A2">A2</option>
                        <option value="B1">B1</option>
                        <option value="B2">B2</option>
                        <option value="C1">C1</option>
                        <option value="C2">C2</option>
                    </select>
                </div>

                <div class="pure-control-group">
                    <label for="pitchDeadline">Angebots&shy;abgabetermin</label>
                    <input type="date" id="pitchDeadline" v-model="request.pitchDeadline" required>
                </div>

                <div class="pure-control-group">
                    <label for="decisionDate">Entscheidungs&shy;termin</label>
                    <input type="date" id="decisionDate" v-model="request.decisionDate" required>
                </div>

                <div class="pure-control-group">
                    <label for="probability">Auftrags&shy;wahrscheinlichkeit</label>
                    <select id="probability" v-model="request.probability" required>
                        <option value="0.25">25%</option>
                        <option value="0.50">50%</option>
                        <option value="0.75">75%</option>
                        <option value="0.80">80%</option>
                        <option value="1">100%</option>
                    </select>
                </div>

                <div class="pure-control-group">
                    <fieldset>
                        <legend>Laufzeit</legend>
                        <label for="runTimeStart">von:</label>
                        <input type="date" id="runTimeStart" v-model="request.runTimeStart" required>
                        <label for="runTimeEnd">bis</label>
                        <input type="date" id="runTimeEnd" v-model="request.runTimeEnd">
                    </fieldset>
                </div>

                <div class="pure-control-group">
                    <label for="dayRate">Tagessatz</label>
                    <input id="dayRate" v-model.number="request.dayRate" type="number" min="1" required>
                    <span class="pure-form-message-inline">&euro; (PT-Satz)</span>
                </div>

                <div class="pure-control-group">
                    <label for="extraConditions">Besonderheiten im Vertrag</label>
                    <textarea id="extraConditions" v-model="request.extraConditions" placeholder=""></textarea>
                    <span class="pure-form-message-inline">(Bsp. Mehraufwand, Reisezeit, o.ä.)</span>
                </div>

                <div class="pure-control-group">
                    <label for="workload">Auslastungsgrad</label>
                    <input id="workload" v-model.number="request.workload" type="number" min="20" max="100" step="20"
                           required> &percnt;
                </div>

                <div class="pure-control-group">
                    <fieldset>
                        <legend>Namen geeigneter Consultants</legend>
                        <div id="candidates">
                            <list-input v-model="request.candidates" label="Name"></list-input>
                        </div>
                    </fieldset>
                </div>

                <div class="pure-control-group">
                    <fieldset id="alternatives">
                        <legend>Alternative Szenarien</legend>
                        <label for="externalConsultants">Freie Berater:</label><input type="checkbox"
                                                                                      id="externalConsultants"
                                                                                      v-model="request.externalConsultants">
                        <label for="entryLevel">Neueinstellung:</label><input type="checkbox" id="entryLevel"
                                                                              v-model="request.entryLevel">
                        <label for="internalBackup">Backup intern:</label><input id="internalBackup"
                                                                                 v-model="request.internalBackup"
                                                                                 placeholder="Name des Beraters">

                    </fieldset>
                </div>

                <div class="pure-control-group">
                    <fieldset>
                        <legend>Wettbewerb und deren Tagessatz</legend>
                        <div id="competition">
                            <map-input v-model="request.competition" key-label="Wettbewerber"
                                       value-label="Tagessatz (€)"></map-input>
                        </div>
                    </fieldset>
                </div>

                <div class="pure-control-group">
                    <label for="followUpBusiness">Direktes Folgegeschäft</label>
                    <textarea id="followUpBusiness" v-model="request.followUpBusiness" placeholder=""></textarea>
                    <span class="pure-form-message-inline">Verlängerung, Teamausbau, etc.</span>
                </div>

                <div class="pure-control-group">
                    <fieldset>
                        <legend>Indirektes Folgegeschäft: Bedeutung für die ...</legend>
                        <div class="pure-control-group">
                            <label for="positioningCustomer">Positionierung in diesem Kunden</label>
                            <select id="positioningCustomer" v-model="request.positioningCustomer">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                            <input type="text" v-model="request.positioningCustomerReason" placeholder="Begründung"
                                   required>
                        </div>

                        <div class="pure-control-group">
                            <label for="crossSellingPotential">Weiteres Wachstum (kundenübergreifende Wirkung)</label>
                            <select id="crossSellingPotential" v-model="request.crossSellingPotential" required>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                            <input type="text" v-model="request.crossSellingPotentialReason" placeholder="Begründung">
                        </div>
                    </fieldset>
                </div>

                <fieldset>
                    <legend>Ansprechpartner</legend>

                    <div class="pure-control-group">
                        <label for="profileSyncContact">Ansprechpartner für Profilabgleich</label>
                        <input id="profileSyncContact" v-model="request.profileSyncContact" placeholder="">
                    </div>
                    <div class="pure-control-group">
                        <label for="externalContact">Ansprechpartner für Telefoninterviews und Auswahltage bei freien
                            Beratern</label>
                        <input id="externalContact" v-model="request.externalContact" placeholder="">
                        <span class="pure-form-message-inline">wenn keine festen zur Verfügung stehen</span>
                    </div>
                </fieldset>

                <fieldset>
                    <legend>Informationen, die wir für die externe Suche nach außen geben:</legend>
                    <span class="pure-form-message-inline">(bitte nur Details nennen, die nicht unmittelbare Rückschlüsse auf den Kunden zulassen)</span>

                    <div class="pure-control-group">
                        <label for="customerType">Kunde</label>
                        <select id="customerType" v-model="request.customerType">
                            <option value="KVG">KVG</option>
                            <option value="PRIVATBANK">Privatbank</option>
                            <option value="SPK">Sparkassen-Sektor</option>
                            <option value="GENO">GENO-Sektor</option>
                        </select>
                    </div>

                    <div class="pure-control-group">
                        <label for="externalRole">Rolle</label>
                        <select id="externalRole" v-model="request.externalRole">
                            <option value="BA">BA</option>
                            <option value="PL">PL</option>
                            <option value="TESTMANAGER">Testmanager</option>
                            <option value="DEVELOPER">Entwickler</option>
                            <option value="ITCONSULTANT">IT-Berater</option>
                            <option value="FPL">Fachliche PL</option>
                            <option value="TPL">Technische PL</option>
                        </select>
                    </div>

                    <div class="pure-control-group">
                        <label for="externalLocation">Einsatzort</label>
                        <input id="externalLocation" v-model="request.externalLocation" placeholder="">
                    </div>

                    <div class="pure-control-group">
                        <label for="externalProjectDescription">Kurze Beschreibung des Projekts </label>
                        <textarea id="externalProjectDescription" v-model="request.externalProjectDescription"
                                  placeholder=""></textarea>
                        <span class="pure-form-message-inline">(Welche Zielstellung verfolgt das Projekt bzw. der Einsatz?)</span>
                    </div>

                    <div class="pure-control-group">
                        <label for="externalTaskDescription">Aufgabenbeschreibung </label>
                        <textarea id="externalTaskDescription" v-model="request.externalTaskDescription"
                                  placeholder=""></textarea>
                        <span class="pure-form-message-inline">(Welche Schnittstellen liegen vor? Einordnung im Projekt)</span>
                    </div>

                    <div class="pure-control-group">
                        <fieldset>
                            <legend for="externalRequiredSkills">Notwendige Skills</legend>
                            <div id="externalRequiredSkills">
                                <list-input v-model="request.externalRequiredSkills" label="Fähigkeit"></list-input>
                            </div>
                            <span class="pure-form-message-inline">(idealerweise in absteigender Wichtigkeit)</span>
                        </fieldset>
                    </div>

                    <div class="pure-control-group">
                        <fieldset>
                            <legend for="externalAdditionalSkills">Wünschenswerte Skills (idealerweise in absteigender
                                Wichtigkeit)
                            </legend>
                            <div id="externalAdditionalSkills">
                                <list-input v-model="request.externalAdditionalSkills" label="Fähigkeit"></list-input>
                            </div>
                            <span class="pure-form-message-inline">(idealerweise in absteigender Wichtigkeit)</span>
                        </fieldset>
                    </div>

                    <div class="pure-control-group">
                        <label for="externalExtensionOption" class="pure-checkbox">Verlängerungsoption</label>
                        <input type="checkbox" id="externalExtensionOption" v-model="request.externalExtensionOption">
                    </div>

                    <div class="pure-control-group">
                        <label for="externalProjectDuration">Projekttag-Dauer (in Stunden)</label>
                        <input id="externalProjectDuration" v-model.number="request.externalProjectDuration"
                               type="number" min="1" max="8">
                    </div>

                    <div class="pure-control-group">
                        <label for="externalExtraConditions">Besonderheiten</label>
                        <textarea id="externalExtraConditions" v-model="request.externalExtraConditions"
                                  placeholder=""></textarea>
                        <span class="pure-form-message-inline">(Bsp. Mehraufwand, Reisezeit, o.ä.)</span>
                    </div>

                </fieldset>

                <div class="pure-controls">
                    <button type="reset" class="pure-button button-error" v-on:click="clear">Zurücksetzen</button>
                    <button type="submit" class="pure-button pure-button-primary" v-on:click.prevent="save('save')"
                            formnovalidate>Speichern
                    </button>
                    <button type="submit" class="pure-button button-success">Veröffentlichen</button>
                </div>
            </fieldset>
        </form>
    </div>
</template>

<script src="./ressourcenanfrage.js"></script>

<style src="PureCss/build/pure-min.css"></style>

<style scoped>
    #ressourcenanfrage {
        margin:1em;
    }

    #submitButton {
        display:none;
    }

    .button-success,
    .button-error,
    .button-warning,
    .button-secondary {
        color: white;
        border-radius: 4px;
        text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
    }

    .button-success {
        background: rgb(28, 184, 65); /* this is a green */
    }

    .button-error {
        background: rgb(202, 60, 60); /* this is a maroon */
    }

    .button-warning {
        background: rgb(223, 117, 20); /* this is an orange */
    }

    .button-secondary {
        background: rgb(66, 184, 221); /* this is a light blue */
    }
    
    #ressourcenanfrage .logo {
        float:right;
    }

</style>