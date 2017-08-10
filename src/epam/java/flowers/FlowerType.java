package epam.java.flowers;

import java.util.ArrayList;
import java.util.List;

enum FlowerType implements Type {
	Subtropical, Temperate;

	enum Cactus implements Type{
		Pilly,Purple,Rocky;
		

		@Override
		public Type getType() {
			return this;
		}

		@Override
		public Type getSyperType() {
			return Subtropical;
		}

		@Override
		public List<Type> getSubTypes() {
			return null;
		}
		
	}
	enum Rose implements Type {
		WhiteRose, YellowRose;
		@Override
		public Type getType() {
			return this;
		}

		@Override
		public Type getSyperType() {
			return Temperate;
		}

		@Override
		public List<Type> getSubTypes() {
			return null;
		}
	}

	enum Peonies implements Type {
		FestivaMaxima, FernLeafPeony;
		@Override
		public Type getType() {
			return this;
		}

		@Override
		public Type getSyperType() {
			return Subtropical;
		}

		@Override
		public List<Type> getSubTypes() {
			return null;
		}
	}

	enum Bougainvillea implements Type {
		BarbaraKarst, VeraPurple;

		@Override
		public Type getType() {
			return this;
		}

		@Override
		public Type getSyperType() {
			return Subtropical;
		}

		@Override
		public List<Type> getSubTypes() {
			return null;
		}
	}

	enum Daffodils implements Type {
		MountHood, YellowRiver, RijnveldEarlySensation;
		@Override
		public Type getType() {
			return this;
		}

		@Override
		public Type getSyperType() {
			return Temperate;
		}

		@Override
		public List<Type> getSubTypes() {
			return null;
		}
	}

	@Override
	public Type getType() {
		return this;
	}

	@Override
	public Type getSyperType() {
		return null;
	}

	@Override
	public List<Type> getSubTypes() {
		return null;
	}
}
// RoseType roseType;
// PeoniesType peoniesType;
// BougainvilleaType bougainvilleaType;
// DaffodilsType daffodilsType;
