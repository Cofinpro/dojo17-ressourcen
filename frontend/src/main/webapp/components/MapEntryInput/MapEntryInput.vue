<template>
    <div class="map-entry-input">
        <label>{{ keyLabel }}</label>
        <input type="text" v-model="item.key" v-on:input="updateValue($event.target.key)" placeholder=""></input>
        <label>{{ valueLabel }}</label>
        <input type="text" v-model="item.value" v-on:input="updateValue($event.target.value)" placeholder=""></input>
        <input type="button" v-on:click="removeInput" value="-"></input>
    </div>
</template>

<script src="./map-entry-input.js">

</script>
