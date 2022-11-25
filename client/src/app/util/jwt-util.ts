function jwt_decode(token:string, key:string) {
    // check token
    if (!token) {
      throw new Error('No token supplied');
    }
    // check segments
    const segments = token.split('.');
    if (segments.length !== 3) {
      throw new Error('Not enough or too many segments');
    }

    return JSON.parse(atob(segments[1]));;
};

export default jwt_decode;