<template>
    <div>
        <String label="Name" v-model="value.name" :editMode="editMode"/>
        <String label="Code" v-model="value.code" :editMode="editMode"/>
        <String label="Spec" v-model="value.spec" :editMode="editMode"/>
        <ProductStatus offline label="ProductStatus" v-model="value.productStatus" :editMode="editMode" @change="change"/>

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
import ProductStatus from './ProductStatus.vue'

export default {
    name: 'Product',
    mixins:[BaseEntity],
    components:{
        String,
        ProductStatus,
    },
    
    data: () => ({
        path: "products"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
