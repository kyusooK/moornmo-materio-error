<template>
    <div>
        <String label="Name" v-model="value.name" :editMode="editMode"/>
        <String label="Industry" v-model="value.industry" :editMode="editMode"/>
        <Date label="FoundedDate" v-model="value.foundedDate" :editMode="editMode"/>
        <Status offline label="ProductStatus" v-model="value.productStatus" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'
import String from './primitives/String.vue'
import Date from './primitives/Date.vue'
import Status from './Status.vue'

export default {
    name: 'Company',
    mixins:[BaseEntity],
    components:{
        String,
        Date,
        Status,
    },
    
    data: () => ({
        path: "companies"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
