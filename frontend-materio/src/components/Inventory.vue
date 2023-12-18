<template>
    <div>
        <Number label="Stock" v-model="value.stock" :editMode="editMode"/>
        <ProductId offline label="ProductId" v-model="value.productId" :editMode="editMode" @change="change"/>

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
import Number from './primitives/Number.vue'
import ProductId from './ProductId.vue'

export default {
    name: 'Inventory',
    mixins:[BaseEntity],
    components:{
        Number,
        ProductId,
    },
    
    data: () => ({
        path: "inventories"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
