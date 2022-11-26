import { JwtPayload } from "jwt-decode";

export interface AuthDetails {
    username: string,
    role: string,
    issued: Date,
    expires: Date
};

export interface TokenPayload extends JwtPayload {
    role?: string;
};