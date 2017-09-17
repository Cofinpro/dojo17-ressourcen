<template>
    <div class="list-entry-input">
        <label>{{ label }}</label>
        <input type="text" v-model="item.value" v-on:input="updateValue($event.target.value)" placeholder=""></input>
        <input type="button" v-on:click="removeInput" value="-"></input>
    </div>
</template>

<script src="./list-entry-input.js"></script>

<style scoped>

</style>