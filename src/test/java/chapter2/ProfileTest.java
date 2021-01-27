package chapter2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfileTest {
	private Profile profile;
	private Question question;
	private Criteria criteria;

	@BeforeEach
	void setUp() {
		profile = new Profile("Bull Hockey, Inc.");
		question = new BooleanQuestion(1, "Got bonuses?");
		criteria = new Criteria();
	}

	@Test
	void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		Answer profileAnswer = new Answer(question, Bool.FALSE);
		profile.add(profileAnswer);

		Criteria criteria = new Criteria();
		Answer criteriaAnswer = new Answer(question, Bool.TRUE);
		Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
		criteria.add(criterion);

		boolean matches = profile.matches(criteria);

		assertFalse(matches);
	}

	@Test
	void matchAnswersTrueForAnyDontCareCriteria() {
		Answer profileAnswer = new Answer(question, Bool.FALSE);
		profile.add(profileAnswer);

		Criteria criteria = new Criteria();
		Answer criteriaAnswer = new Answer(question, Bool.TRUE);
		Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
		criteria.add(criterion);

		boolean matches = profile.matches(criteria);

		assertTrue(matches);
	}
}