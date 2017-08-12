package epam.java.flowers;

enum FlowerType implements Type {
	ROSE,CACTUS,PEONIES,BOUGAINVILLEA,DAFFODILS;

	enum Cactus implements Type{
		PILLY,PURPLE,ROCKY;
		

		@Override
		public Type getType() {
			return this;
		}

		@Override
		public Type getSyperType() {
			return CACTUS;
		}
		
	}
	enum Rose implements Type {
		WHITEROSE, YELLOWROSE;
		@Override
		public Type getType() {
			return this;
		}

		@Override
		public Type getSyperType() {
			return ROSE;
		}

		
	}

	enum Peonies implements Type {
		FESTIVAMAXIMA, FERNLEAFPEONY;
		@Override
		public Type getType() {
			return this;
		}

		@Override
		public Type getSyperType() {
			return PEONIES;
		}

		
	}

	enum Bougainvillea implements Type {
		BARBARAKARST, VERAPURPLE;

		@Override
		public Type getType() {
			return this;
		}

		@Override
		public Type getSyperType() {
			return BOUGAINVILLEA;
		}

		
	}

	enum Daffodils implements Type {
		MOUNTHOOD, YELLOWRIVER, RIJNVELDEARLYSENSATION;
		@Override
		public Type getType() {
			return this;
		}

		@Override
		public Type getSyperType() {
			return DAFFODILS;
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

	
}
// RoseType roseType;
// PeoniesType peoniesType;
// BougainvilleaType bougainvilleaType;
// DaffodilsType daffodilsType;
