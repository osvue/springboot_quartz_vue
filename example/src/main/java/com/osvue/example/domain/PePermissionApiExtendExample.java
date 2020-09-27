package com.osvue.example.domain;

import java.util.ArrayList;
import java.util.List;

public class PePermissionApiExtendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PePermissionApiExtendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andApiLevelIsNull() {
            addCriterion("api_level is null");
            return (Criteria) this;
        }

        public Criteria andApiLevelIsNotNull() {
            addCriterion("api_level is not null");
            return (Criteria) this;
        }

        public Criteria andApiLevelEqualTo(Integer value) {
            addCriterion("api_level =", value, "apiLevel");
            return (Criteria) this;
        }

        public Criteria andApiLevelNotEqualTo(Integer value) {
            addCriterion("api_level <>", value, "apiLevel");
            return (Criteria) this;
        }

        public Criteria andApiLevelGreaterThan(Integer value) {
            addCriterion("api_level >", value, "apiLevel");
            return (Criteria) this;
        }

        public Criteria andApiLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("api_level >=", value, "apiLevel");
            return (Criteria) this;
        }

        public Criteria andApiLevelLessThan(Integer value) {
            addCriterion("api_level <", value, "apiLevel");
            return (Criteria) this;
        }

        public Criteria andApiLevelLessThanOrEqualTo(Integer value) {
            addCriterion("api_level <=", value, "apiLevel");
            return (Criteria) this;
        }

        public Criteria andApiLevelIn(List<Integer> values) {
            addCriterion("api_level in", values, "apiLevel");
            return (Criteria) this;
        }

        public Criteria andApiLevelNotIn(List<Integer> values) {
            addCriterion("api_level not in", values, "apiLevel");
            return (Criteria) this;
        }

        public Criteria andApiLevelBetween(Integer value1, Integer value2) {
            addCriterion("api_level between", value1, value2, "apiLevel");
            return (Criteria) this;
        }

        public Criteria andApiLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("api_level not between", value1, value2, "apiLevel");
            return (Criteria) this;
        }

        public Criteria andApiMethodIsNull() {
            addCriterion("api_method is null");
            return (Criteria) this;
        }

        public Criteria andApiMethodIsNotNull() {
            addCriterion("api_method is not null");
            return (Criteria) this;
        }

        public Criteria andApiMethodEqualTo(String value) {
            addCriterion("api_method =", value, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodNotEqualTo(String value) {
            addCriterion("api_method <>", value, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodGreaterThan(String value) {
            addCriterion("api_method >", value, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodGreaterThanOrEqualTo(String value) {
            addCriterion("api_method >=", value, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodLessThan(String value) {
            addCriterion("api_method <", value, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodLessThanOrEqualTo(String value) {
            addCriterion("api_method <=", value, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodLike(String value) {
            addCriterion("api_method like", value, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodNotLike(String value) {
            addCriterion("api_method not like", value, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodIn(List<String> values) {
            addCriterion("api_method in", values, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodNotIn(List<String> values) {
            addCriterion("api_method not in", values, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodBetween(String value1, String value2) {
            addCriterion("api_method between", value1, value2, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiMethodNotBetween(String value1, String value2) {
            addCriterion("api_method not between", value1, value2, "apiMethod");
            return (Criteria) this;
        }

        public Criteria andApiUrlIsNull() {
            addCriterion("api_url is null");
            return (Criteria) this;
        }

        public Criteria andApiUrlIsNotNull() {
            addCriterion("api_url is not null");
            return (Criteria) this;
        }

        public Criteria andApiUrlEqualTo(String value) {
            addCriterion("api_url =", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotEqualTo(String value) {
            addCriterion("api_url <>", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlGreaterThan(String value) {
            addCriterion("api_url >", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlGreaterThanOrEqualTo(String value) {
            addCriterion("api_url >=", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLessThan(String value) {
            addCriterion("api_url <", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLessThanOrEqualTo(String value) {
            addCriterion("api_url <=", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLike(String value) {
            addCriterion("api_url like", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotLike(String value) {
            addCriterion("api_url not like", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlIn(List<String> values) {
            addCriterion("api_url in", values, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotIn(List<String> values) {
            addCriterion("api_url not in", values, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlBetween(String value1, String value2) {
            addCriterion("api_url between", value1, value2, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotBetween(String value1, String value2) {
            addCriterion("api_url not between", value1, value2, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdEqualTo(Long value) {
            addCriterion("permission_id =", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(Long value) {
            addCriterion("permission_id <>", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(Long value) {
            addCriterion("permission_id >", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("permission_id >=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(Long value) {
            addCriterion("permission_id <", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(Long value) {
            addCriterion("permission_id <=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIn(List<Long> values) {
            addCriterion("permission_id in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<Long> values) {
            addCriterion("permission_id not in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(Long value1, Long value2) {
            addCriterion("permission_id between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(Long value1, Long value2) {
            addCriterion("permission_id not between", value1, value2, "permissionId");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}