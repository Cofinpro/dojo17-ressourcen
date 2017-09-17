export default {
    name: 'map-entry-input',
    props: ['item', 'keyLabel', 'valueLabel'],
    methods: {
        updateValue: function (value) {
            this.$emit('input', value);
        },
        removeInput: function () {
            this.$emit('removed');
        }
    }
}