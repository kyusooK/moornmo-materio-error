<template>
    <div style="margin: 0 -15px 0 -15px;">
        <v-card-title>
            SalesStatus
        </v-card-title>
        <v-card-text>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-select
                        v-model="newValue"
                        :label="'name'"
                        :items="SalesStatusList"
                ></v-select>
            </div>
            <div v-else style="margin-top:-20px;">
                SalesStatus : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name: 'SalesStatus',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
            salesStatusList : [ "Delivered",  "InProduction",  "Ready", ],
            newValue: '',
        }),
        async created() {
            if(!this.value) {
                this.newValue = this.salesStatusList[0];
            } else {
                this.newValue = this.value;
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },
        methods: {
        }
    }
</script>

