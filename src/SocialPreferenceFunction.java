
public abstract class SocialPreferenceFunction {
	public abstract void elect();
	public static Selection lookup(int id)
	{
		for(Selection s: Election.candidates)
			if (s.getID() == id)
				return s;
		return null;
	}
}

