<template>
    <div class="list-input">
        <list-entry-input v-bind:label="label" v-for="(item, index) in value" :item="item" :key="index"
                         v-on:input="propagateChange" v-on:removed="removeListItem(index)"></list-entry-input>
        <input type="button" v-on:click="addInput" value="+"></input>
    </div>
</template>

<script src="./list-input.js"></script>

<style scoped>

</style>