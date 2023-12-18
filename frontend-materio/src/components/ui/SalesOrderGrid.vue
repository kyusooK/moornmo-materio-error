<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="produceDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>생산완료
                </v-btn>
                <v-dialog v-model="produceDialog" width="500">
                    <Produce
                        @closeDialog="produceDialog = false"
                        @produce="produce"
                    ></Produce>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>SalesOrderNumber</th>
                        <th>SalesPerson</th>
                        <th>SalesType</th>
                        <th>CompanyId</th>
                        <th>SalesStatus</th>
                        <th>SalesItems</th>
                        <th>회사정보</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="SalesOrderNumber">{{ val.salesOrderNumber }}</td>
                            <td class="whitespace-nowrap" label="SalesPerson">{{ val.salesPerson }}</td>
                            <td class="whitespace-nowrap" label="SalesType">{{ val.salesType }}</td>
                            <td class="whitespace-nowrap" label="SalesStatus">{{ val.salesStatus }}</td>
                            <td class="whitespace-nowrap" label="회사정보">
                                <CompanyId :editMode="editMode" v-model="val.companyId"></CompanyId>
                            </td>
                            <Icon style="margin-top: 15px;" icon="mi:delete" @click="deleteRow(val)" />
                        </tr>
                    </tbody>
                </v-table>
            </div>
            <SalesItemDetailGrid style="margin-top: 20px;" label="SalesItems" offline v-if="selectedRow" v-model="selectedRow.salesItems" :selectedRow="selectedRow"/>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">SalesOrder 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <SalesOrder :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">SalesOrder 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="SalesOrderNumber" v-model="selectedRow.salesOrderNumber" :editMode="true"/>
                            <String label="SalesPerson" v-model="selectedRow.salesPerson" :editMode="true"/>
                            <SalesType offline label="SalesType" v-model="selectedRow.salesType" :editMode="true"/4>
                            <CompanyId offline label="CompanyId" v-model="selectedRow.companyId" :editMode="true"/4>
                            <SalesStatus offline label="SalesStatus" v-model="selectedRow.salesStatus" :editMode="true"/4>
                            <SalesItemDetailGrid label="SalesItems" offline v-model="selectedRow.salesItems" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'
import SalesOrder from '../SalesOrder.vue'
import Number from '../primitives/Number.vue'
import String from '../primitives/String.vue'
import SalesType from '../SalesType.vue'
import CompanyId from '../CompanyId.vue'
import SalesStatus from '../SalesStatus.vue'
import SalesItemDetailGrid from './SalesItemDetailGrid.vue'
import Produce from '../Produce.vue'

export default {
    name: 'salesOrderGrid',
    mixins:[BaseGrid],
    components:{
        SalesOrder,
        Number,
        String,
        SalesType,
        CompanyId,
        SalesStatus,
        SalesItemDetailGrid,
        Produce,
    },
    data: () => ({
        path: 'salesOrders',
        produceDialog: false,
    }),
    watch: {
    },
    methods:{
        produce(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "produce", params)
                this.$EventBus.$emit('show-success','produce 성공적으로 처리되었습니다.')
                this.produceDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
    }
}

</script>