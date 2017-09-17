import MapEntryInput from '../MapEntryInput/MapEntryInput.vue'

export default {
    name: 'map-input',
    components: {
        MapEntryInput
    },
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
}