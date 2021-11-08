<template>
    <el-card class="box-card">

        <el-form :inline="true" :model="searchForm" class="demo-form-inline">
            <el-form-item label="查询">
                <el-input v-model="searchForm.name" placeholder="学生姓名"></el-input>
            </el-form-item>
            <el-form-item>
                <el-input v-model="searchForm.addr" placeholder="居住地址"></el-input>
            </el-form-item>
            <el-form-item label="班级">
                <el-select v-model="searchForm.cid" placeholder="所在班级">
                    <el-option label="所有班级" value="0"></el-option>
                    <el-option :label="c.cname" :value="c.cid" v-for="c in classes"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="search()" icon="el-icon-search">查询</el-button>
            </el-form-item>
        </el-form>

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
                students: [],   //代表每页学生数
                classes: [],    //所有班级
                pageSize:5,     //代表每页大小
                page:1,         //地表当前页
                total:20,      //代表总页数
                searchForm:{},  //被搜索的学生变量
            }
        },
        created() {
            //1. 查询所有学生
            // this.findAllStudents();
            //2. 分页查询
            // this.findPage(this.page,this.pageSize);
            // 3. 查询所有班级
            this.findAllClasses();
            //4. 分页带条件查询
            this.search();
        },
        methods:{
            //0.查询所有数据
            findAllStudents(){
                this.axios.get(`/student?cmd=list`).then(data=>{
                    console.log("data:",data);
                    // 1.1为总记录数赋值
                    this.students=data.data;
                })
            },
            //1. 查询所有学生
            findPage(page,pageSize){
                this.axios.get(`/student?cmd=findPage&page=${page}&pageSize=${pageSize}`).then(data=>{
                    console.log("data:",data);
                    // 1.1为总记录数赋值
                    this.total=data.data.total;
                    // 1.2为当前页的记录集合赋值
                    this.students=data.data.rows;


                })
            },
            //2. 每页大小（pagesize）改变时触发
            handleSizeChange(pageSize){
                console.log(`每页${pageSize}条`);
                this.pageSize=pageSize;
                this.search(this.page,this.pageSize);
            },
            //3. 每页page改变时触发
            handleCurrentChange(page){
                console.log(`当前页:${page}`);
                this.page=page;
                this.search(this.page,this.pageSize);
            },

            //4. 查询所有班级
            findAllClasses(){
                this.axios.get("/classes").then(data=>{
                    this.classes = data.data;
                })
            },

            //5. 条件查询带分页
            search(){
                this.axios.post(`/student?cmd=search&page=${this.page}&pageSize=${this.pageSize}`,
                    "stud="+JSON.stringify(this.searchForm)).then(data=>{
                    // 1.1 为总记录数赋值
                    this.total=data.data.total;
                    // 1.2 为当前页的记录集合赋值
                    this.students=data.data.rows;

                })
            },
        },

    }
</script>

<style scoped>

    .el-pagination{
        margin-top: 20px;
        text-align: right;
    }
    .el-from{
       text-align: left;
    }

</style>