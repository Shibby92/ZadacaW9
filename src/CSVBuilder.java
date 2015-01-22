public class CSVBuilder {
	
	// CR: Vidio sam da ste koristili StringBuilder pa bih to preporucio brzine radi
	// i kada imas bitne propertije (kao sto je ovaj member) koristi malo smislenije ime 
	// cvsBuilder, cvsBuffer, result, cvsContent, cvsResult etc.
	String res;

	/**
	 * Appends provided string to existing CSV line.
	 * 
	 * @param str
	 *            value to append to line
	 * @return this builder
	 * @throws NullPointerException
	 *             in case provided object is null
	 */
	// CR: Sredi code ne valja formating, imas automatski COMMAND+SHIFT+F (Mac) CTRL+SHIFT+F (Win)
	public CSVBuilder append(String str) {
		if (res != null) {
			// CR: ovjde provjeri da li pocinje string sa ',' ako pocinje onda ga smao conact - ti provjeravas da li je zarez
			// sto nije dovoljno
			if(res!=","){
			res = res.concat(",").concat(str);
			}
			else{
				res=res.concat(str);
			}
		} else {
			// CR: Zasto ukloniti postojece rezultate sa null-om ako je null onda ne moj nista uraditi 
			// dobar mini-patern je da napises na pocetku metode
			// if (str == null) {
			//   return this;
			// }
			// Pa ti ne treba if / else da komplikuje logiku 
			res = str;
		}
		
		// CR: Mislim da ti ovo ne treba
		if (str=="," && res==null){
			res = res.concat(",");
		}else if (str == null){
			return this;
		}
		
		return this;
	}

	
	// CR: Odlicno! ovo ispod
	/**
	 * Appends string representation of provided object to existing CSV line.
	 * 
	 * @param str
	 *            value to append to line
	 * @return this builder
	 * @throws NullPointerException
	 *             in case provided object is null
	 */
	public CSVBuilder append(Object obj) {
		return append(obj.toString());
	}

	/**
	 * Resets builder.
	 */
	public void clear() {
		res = null;
	}

	@Override
	public String toString() {
		if (res != null) {
			return res;
		}
		return "";
	}

}