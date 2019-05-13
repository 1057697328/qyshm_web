package net.lightwing.qyshm_web.pojo;

import java.util.ArrayList;
import java.util.List;

public class QTeamtypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public QTeamtypeExample() {
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

        public Criteria andTtypeidIsNull() {
            addCriterion("ttypeid is null");
            return (Criteria) this;
        }

        public Criteria andTtypeidIsNotNull() {
            addCriterion("ttypeid is not null");
            return (Criteria) this;
        }

        public Criteria andTtypeidEqualTo(Integer value) {
            addCriterion("ttypeid =", value, "ttypeid");
            return (Criteria) this;
        }

        public Criteria andTtypeidNotEqualTo(Integer value) {
            addCriterion("ttypeid <>", value, "ttypeid");
            return (Criteria) this;
        }

        public Criteria andTtypeidGreaterThan(Integer value) {
            addCriterion("ttypeid >", value, "ttypeid");
            return (Criteria) this;
        }

        public Criteria andTtypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ttypeid >=", value, "ttypeid");
            return (Criteria) this;
        }

        public Criteria andTtypeidLessThan(Integer value) {
            addCriterion("ttypeid <", value, "ttypeid");
            return (Criteria) this;
        }

        public Criteria andTtypeidLessThanOrEqualTo(Integer value) {
            addCriterion("ttypeid <=", value, "ttypeid");
            return (Criteria) this;
        }

        public Criteria andTtypeidIn(List<Integer> values) {
            addCriterion("ttypeid in", values, "ttypeid");
            return (Criteria) this;
        }

        public Criteria andTtypeidNotIn(List<Integer> values) {
            addCriterion("ttypeid not in", values, "ttypeid");
            return (Criteria) this;
        }

        public Criteria andTtypeidBetween(Integer value1, Integer value2) {
            addCriterion("ttypeid between", value1, value2, "ttypeid");
            return (Criteria) this;
        }

        public Criteria andTtypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("ttypeid not between", value1, value2, "ttypeid");
            return (Criteria) this;
        }

        public Criteria andTtypenameIsNull() {
            addCriterion("ttypename is null");
            return (Criteria) this;
        }

        public Criteria andTtypenameIsNotNull() {
            addCriterion("ttypename is not null");
            return (Criteria) this;
        }

        public Criteria andTtypenameEqualTo(String value) {
            addCriterion("ttypename =", value, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameNotEqualTo(String value) {
            addCriterion("ttypename <>", value, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameGreaterThan(String value) {
            addCriterion("ttypename >", value, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameGreaterThanOrEqualTo(String value) {
            addCriterion("ttypename >=", value, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameLessThan(String value) {
            addCriterion("ttypename <", value, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameLessThanOrEqualTo(String value) {
            addCriterion("ttypename <=", value, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameLike(String value) {
            addCriterion("ttypename like", value, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameNotLike(String value) {
            addCriterion("ttypename not like", value, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameIn(List<String> values) {
            addCriterion("ttypename in", values, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameNotIn(List<String> values) {
            addCriterion("ttypename not in", values, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameBetween(String value1, String value2) {
            addCriterion("ttypename between", value1, value2, "ttypename");
            return (Criteria) this;
        }

        public Criteria andTtypenameNotBetween(String value1, String value2) {
            addCriterion("ttypename not between", value1, value2, "ttypename");
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