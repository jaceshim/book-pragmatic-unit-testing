package chapter2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfileTest {
	@Test
	void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		Profile profile = new Profile("Bul Hockey, Inc.");
		Question question = new BooleanQuestion(1, "Got bonuses?");
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
		Profile profile = new Profile("Bul Hockey, Inc.");
		Question question = new BooleanQuestion(1, "Got milk?");
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