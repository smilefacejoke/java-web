<template>
    <el-card class="box-card">

        <el-table
                :data="students"
                style="width: 100%">
            <el-table-column
                    label="学号"
                    align="center"
                    prop="sid"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="姓名"
                    align="center"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="age"
                    label="年龄"
                    align="center"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="addr"
                    label="住址"
                    align="center"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="cname"
                    align="center"
                    label="所在班级"
                    width="180">
            </el-table-column>
            <el-table-column label="操作" align="center">
                <template slot-scope="scope">
                    <el-button
                            type="success"
                            plain
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            plain
                            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="page"
                :page-sizes="[3, 4, 5, 6]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
        </el-pagination>

    </el-card>

</template>

<script>
    export default {
        name: "Student",
        data(){
            return {
                students: [],
                classes: [],
                pageSize:5,     //代表每页大小
                page:1,         //地表当前页
                total:20,      //代表总页数
            }
        },
        created() {
          //1. 查询所有学生
          this.findAllStudents();
          //
        },
        methods:{
            //1. 查询所有学生
            findAllStudents(){
                this.axios.get("/student?cmd=list").then(data=>{
                    console.log("data:",data);
                    this.students = data.data
                })
            },
            //2. 每页大小（pagesize）改变时触发
            handleSizeChange(val){
                console.log(`每页${val}条`);
            },
            //3. 每页page改变时触发
            handleCurrentChange(val){
                console.log(`当前页:${val}`);
            }

        },

    }
</script>

<style scoped>

    .el-pagination{
        margin-top: 20px;
        text-align: right;
    }

</style>