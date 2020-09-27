
 
import request from '@/request/index.js'
const group_name = 'job'
export default {
    jobList(page) {
        return request({
            url: `/api/${group_name}/list`,
            method: 'post',
            data: page
        })
    },
    trigger(data) {
        return request({
            url: `/api/${group_name}/trigger`,
            method: 'post',
            data 
        })
    },
    updateOrAdd(data) {
        return request({
            url: `/api/${group_name}/add`,
            method: 'post',
            data
        })
    },
    stopJob(data) {
        return request({
            url: `/api/${group_name}/pause`,
            method: 'post',
            data
        })
    },
    resumeJob(data) {
        return request({
            url: `/api/${group_name}/resume`,
            method: 'post'
            ,data
        })
    },
    removeJob(data) {
        return request({
            url: `/api/${group_name}/remove`,
            method: 'post'
            ,data
        })
    },
}

