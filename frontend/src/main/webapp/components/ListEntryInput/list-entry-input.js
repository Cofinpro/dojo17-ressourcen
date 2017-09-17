export default {
    name: 'removable-input',
    props: ['item', 'label'],
    methods: {
        updateValue: function (value) {
            this.$emit('input', value);
        },
        removeInput: function () {
            this.$emit('removed');
        }
    }
}
