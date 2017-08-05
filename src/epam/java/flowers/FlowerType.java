package epam.java.flowers;

import java.util.List;

enum FlowerType implements Type {
	Subtropical, Temperate;

	enum RoseType implements Type {
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

	enum PeoniesType implements Type {
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

	enum BougainvilleaType implements Type {
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

	enum DaffodilsType implements Type {
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
