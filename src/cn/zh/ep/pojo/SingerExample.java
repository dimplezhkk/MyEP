package cn.zh.ep.pojo;

import java.util.ArrayList;
import java.util.List;

public class SingerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SingerExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSingerIsNull() {
            addCriterion("singer is null");
            return (Criteria) this;
        }

        public Criteria andSingerIsNotNull() {
            addCriterion("singer is not null");
            return (Criteria) this;
        }

        public Criteria andSingerEqualTo(String value) {
            addCriterion("singer =", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotEqualTo(String value) {
            addCriterion("singer <>", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerGreaterThan(String value) {
            addCriterion("singer >", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerGreaterThanOrEqualTo(String value) {
            addCriterion("singer >=", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerLessThan(String value) {
            addCriterion("singer <", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerLessThanOrEqualTo(String value) {
            addCriterion("singer <=", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerLike(String value) {
            addCriterion("singer like", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotLike(String value) {
            addCriterion("singer not like", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerIn(List<String> values) {
            addCriterion("singer in", values, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotIn(List<String> values) {
            addCriterion("singer not in", values, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerBetween(String value1, String value2) {
            addCriterion("singer between", value1, value2, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotBetween(String value1, String value2) {
            addCriterion("singer not between", value1, value2, "singer");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSingertypeIsNull() {
            addCriterion("singertype is null");
            return (Criteria) this;
        }

        public Criteria andSingertypeIsNotNull() {
            addCriterion("singertype is not null");
            return (Criteria) this;
        }

        public Criteria andSingertypeEqualTo(String value) {
            addCriterion("singertype =", value, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeNotEqualTo(String value) {
            addCriterion("singertype <>", value, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeGreaterThan(String value) {
            addCriterion("singertype >", value, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeGreaterThanOrEqualTo(String value) {
            addCriterion("singertype >=", value, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeLessThan(String value) {
            addCriterion("singertype <", value, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeLessThanOrEqualTo(String value) {
            addCriterion("singertype <=", value, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeLike(String value) {
            addCriterion("singertype like", value, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeNotLike(String value) {
            addCriterion("singertype not like", value, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeIn(List<String> values) {
            addCriterion("singertype in", values, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeNotIn(List<String> values) {
            addCriterion("singertype not in", values, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeBetween(String value1, String value2) {
            addCriterion("singertype between", value1, value2, "singertype");
            return (Criteria) this;
        }

        public Criteria andSingertypeNotBetween(String value1, String value2) {
            addCriterion("singertype not between", value1, value2, "singertype");
            return (Criteria) this;
        }

        public Criteria andHotIsNull() {
            addCriterion("hot is null");
            return (Criteria) this;
        }

        public Criteria andHotIsNotNull() {
            addCriterion("hot is not null");
            return (Criteria) this;
        }

        public Criteria andHotEqualTo(String value) {
            addCriterion("hot =", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotEqualTo(String value) {
            addCriterion("hot <>", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThan(String value) {
            addCriterion("hot >", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThanOrEqualTo(String value) {
            addCriterion("hot >=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThan(String value) {
            addCriterion("hot <", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThanOrEqualTo(String value) {
            addCriterion("hot <=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLike(String value) {
            addCriterion("hot like", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotLike(String value) {
            addCriterion("hot not like", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotIn(List<String> values) {
            addCriterion("hot in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotIn(List<String> values) {
            addCriterion("hot not in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotBetween(String value1, String value2) {
            addCriterion("hot between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotBetween(String value1, String value2) {
            addCriterion("hot not between", value1, value2, "hot");
            return (Criteria) this;
        }
    }

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