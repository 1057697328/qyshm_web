package net.lightwing.qyshm_web.pojo;

import java.util.ArrayList;
import java.util.List;

public class QBottommenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public QBottommenuExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andBmidIsNull() {
            addCriterion("bmid is null");
            return (Criteria) this;
        }

        public Criteria andBmidIsNotNull() {
            addCriterion("bmid is not null");
            return (Criteria) this;
        }

        public Criteria andBmidEqualTo(Integer value) {
            addCriterion("bmid =", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidNotEqualTo(Integer value) {
            addCriterion("bmid <>", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidGreaterThan(Integer value) {
            addCriterion("bmid >", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bmid >=", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidLessThan(Integer value) {
            addCriterion("bmid <", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidLessThanOrEqualTo(Integer value) {
            addCriterion("bmid <=", value, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidIn(List<Integer> values) {
            addCriterion("bmid in", values, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidNotIn(List<Integer> values) {
            addCriterion("bmid not in", values, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidBetween(Integer value1, Integer value2) {
            addCriterion("bmid between", value1, value2, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmidNotBetween(Integer value1, Integer value2) {
            addCriterion("bmid not between", value1, value2, "bmid");
            return (Criteria) this;
        }

        public Criteria andBmtitleIsNull() {
            addCriterion("bmtitle is null");
            return (Criteria) this;
        }

        public Criteria andBmtitleIsNotNull() {
            addCriterion("bmtitle is not null");
            return (Criteria) this;
        }

        public Criteria andBmtitleEqualTo(String value) {
            addCriterion("bmtitle =", value, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleNotEqualTo(String value) {
            addCriterion("bmtitle <>", value, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleGreaterThan(String value) {
            addCriterion("bmtitle >", value, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleGreaterThanOrEqualTo(String value) {
            addCriterion("bmtitle >=", value, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleLessThan(String value) {
            addCriterion("bmtitle <", value, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleLessThanOrEqualTo(String value) {
            addCriterion("bmtitle <=", value, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleLike(String value) {
            addCriterion("bmtitle like", value, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleNotLike(String value) {
            addCriterion("bmtitle not like", value, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleIn(List<String> values) {
            addCriterion("bmtitle in", values, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleNotIn(List<String> values) {
            addCriterion("bmtitle not in", values, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleBetween(String value1, String value2) {
            addCriterion("bmtitle between", value1, value2, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmtitleNotBetween(String value1, String value2) {
            addCriterion("bmtitle not between", value1, value2, "bmtitle");
            return (Criteria) this;
        }

        public Criteria andBmhrefIsNull() {
            addCriterion("bmhref is null");
            return (Criteria) this;
        }

        public Criteria andBmhrefIsNotNull() {
            addCriterion("bmhref is not null");
            return (Criteria) this;
        }

        public Criteria andBmhrefEqualTo(String value) {
            addCriterion("bmhref =", value, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefNotEqualTo(String value) {
            addCriterion("bmhref <>", value, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefGreaterThan(String value) {
            addCriterion("bmhref >", value, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefGreaterThanOrEqualTo(String value) {
            addCriterion("bmhref >=", value, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefLessThan(String value) {
            addCriterion("bmhref <", value, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefLessThanOrEqualTo(String value) {
            addCriterion("bmhref <=", value, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefLike(String value) {
            addCriterion("bmhref like", value, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefNotLike(String value) {
            addCriterion("bmhref not like", value, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefIn(List<String> values) {
            addCriterion("bmhref in", values, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefNotIn(List<String> values) {
            addCriterion("bmhref not in", values, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefBetween(String value1, String value2) {
            addCriterion("bmhref between", value1, value2, "bmhref");
            return (Criteria) this;
        }

        public Criteria andBmhrefNotBetween(String value1, String value2) {
            addCriterion("bmhref not between", value1, value2, "bmhref");
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