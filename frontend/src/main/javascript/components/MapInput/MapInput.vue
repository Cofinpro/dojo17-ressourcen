<template>
    <div class="map-input">
        <map-entry-input v-bind:keyLabel="keyLabel" v-bind:valueLabel="valueLabel" v-for="(item, index) in value"
                              :item="item" :key="index" v-on:input="propagateChange"
                              v-on:removed="removeListItem(index)"></map-entry-input>
        <input type="button" v-on:click="addInput" value="+"></input>
    </div>
</template>

<script src="./map-input.js"></script>

<style scoped></style>