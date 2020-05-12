package cn.zh.ep.pojo;

import java.util.ArrayList;
import java.util.List;

public class SendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SendExample() {
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

        public Criteria andMusicnameIsNull() {
            addCriterion("musicname is null");
            return (Criteria) this;
        }

        public Criteria andMusicnameIsNotNull() {
            addCriterion("musicname is not null");
            return (Criteria) this;
        }

        public Criteria andMusicnameEqualTo(String value) {
            addCriterion("musicname =", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameNotEqualTo(String value) {
            addCriterion("musicname <>", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameGreaterThan(String value) {
            addCriterion("musicname >", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameGreaterThanOrEqualTo(String value) {
            addCriterion("musicname >=", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameLessThan(String value) {
            addCriterion("musicname <", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameLessThanOrEqualTo(String value) {
            addCriterion("musicname <=", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameLike(String value) {
            addCriterion("musicname like", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameNotLike(String value) {
            addCriterion("musicname not like", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameIn(List<String> values) {
            addCriterion("musicname in", values, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameNotIn(List<String> values) {
            addCriterion("musicname not in", values, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameBetween(String value1, String value2) {
            addCriterion("musicname between", value1, value2, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameNotBetween(String value1, String value2) {
            addCriterion("musicname not between", value1, value2, "musicname");
            return (Criteria) this;
        }

        public Criteria andSingernameIsNull() {
            addCriterion("singername is null");
            return (Criteria) this;
        }

        public Criteria andSingernameIsNotNull() {
            addCriterion("singername is not null");
            return (Criteria) this;
        }

        public Criteria andSingernameEqualTo(String value) {
            addCriterion("singername =", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameNotEqualTo(String value) {
            addCriterion("singername <>", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameGreaterThan(String value) {
            addCriterion("singername >", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameGreaterThanOrEqualTo(String value) {
            addCriterion("singername >=", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameLessThan(String value) {
            addCriterion("singername <", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameLessThanOrEqualTo(String value) {
            addCriterion("singername <=", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameLike(String value) {
            addCriterion("singername like", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameNotLike(String value) {
            addCriterion("singername not like", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameIn(List<String> values) {
            addCriterion("singername in", values, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameNotIn(List<String> values) {
            addCriterion("singername not in", values, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameBetween(String value1, String value2) {
            addCriterion("singername between", value1, value2, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameNotBetween(String value1, String value2) {
            addCriterion("singername not between", value1, value2, "singername");
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