
<template>


  <div>

    <!--    加个筛选表的窗口-->

    <el-table
        :data="tableData"
        border
        style="width: 100%">
      <el-table-column
          fixed
          prop="id"
          label="Id"
          width="70">
      </el-table-column>
      <el-table-column
          prop="vin"
          label="VIN"
          width="120">
      </el-table-column>
      <el-table-column
          prop="brand"
          label="Brand"
          width="122">
      </el-table-column>
      <el-table-column
          prop="price"
          label="Price"
          width="115">
      </el-table-column>
      <el-table-column
          prop="numOfSeats"
          label="Number of Seats"
          width="120">
      </el-table-column>
      <el-table-column
          prop="mileage"
          label="Mileage"
          width="120">
      </el-table-column>
      <el-table-column
          prop="availability"
          label="Availability"
          width="100">
      </el-table-column>
      <el-table-column
          prop="address"
          label="Address"
          width="100">
      </el-table-column>

      <el-table-column
          prop="info"
          label="Info"
          width="100">
      </el-table-column>



    </el-table>


  </div>
</template>

<script>
  export default {
    methods: {
      edit(row) {
        this.$router.push({
          path:'/update',
          query:{
            id:row.id
          }
        })
      },



    },

    data() {
      return {
        tableData: null,
      }
    },

    created() {
      const _this = this
      axios.get('http://localhost:8181/vehicle/findByAvailability/1').then(function (resp) {
        _this.tableData = resp.data
      })
    }
  }
</script>

<style>

</style>
