
 
import request from '@/request/index.js'
const group_name = 'user'
export default {
    userList(page) {
        return request({
            url: `/api/${group_name}/page`,
            method: 'post',
            data: page
        })
    },
    update(user) {
        return request({
            url: `/api/${group_name}/update`,
            method: 'put',
            data: user
        })
    },
    deleteById(id) {
        return request({
            url: `/api/${group_name}/delete//${id}`,
            method: 'delete'
        })
    },
    save(user) {
        return request({
            url: `/api/${group_name}/save`,
            method: 'post',
            data: user
        })
    },
    getById(id) {
        return request({
            url: `/api/${group_name}/get//${id}`,
            method: 'get'
        })
    },
}

