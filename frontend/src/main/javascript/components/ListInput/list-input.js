import ListEntryInput from '../ListEntryInput/ListEntryInput.vue'

export default {
    name: 'multi-inputs',
    components: {
        ListEntryInput
    },
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
}